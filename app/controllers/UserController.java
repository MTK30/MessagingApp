package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import services.UserService;
import skeletons.request.ActiveInactiveRequest;
import skeletons.request.AddContactRequest;
import skeletons.request.CreateUserRequest;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;



@Singleton
public class UserController  extends Controller {
    private UserService userService;
    private final NormalExecutionContext normalExecutionContext;

    @Inject
    public UserController(UserService userService,
                          NormalExecutionContext normalExecutionContext)
    {
        this.userService = userService;
        this.normalExecutionContext = normalExecutionContext;
    }

    public CompletionStage<Result> createUser(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        CreateUserRequest createUserRequest = CreateUserRequest.build(request.body().asJson());
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(userService.addUser(createUserRequest));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> getUserData() {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(userService.getUser());
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> getContactsOnline(Long userId){
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(userService.usersOnline(userId));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> addToContact(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        AddContactRequest addContactRequest = AddContactRequest.build(request.body().asJson());
        //@TODO validations
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(userService.addContacts(addContactRequest.getContactsId(),addContactRequest.getUserId()));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> setActiveInactive(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        ActiveInactiveRequest activeInactiveRequest = ActiveInactiveRequest.build(request.body().asJson());
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(userService.setActiveInactive(activeInactiveRequest));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

}
