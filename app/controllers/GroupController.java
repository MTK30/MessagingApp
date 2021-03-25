package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import models.User;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import services.GroupsService;
import skeletons.request.AddUserToGroupRequest;
import skeletons.request.CreateGroupRequest;
import skeletons.request.CreateUserRequest;
import skeletons.response.Response;
import skeletons.response.SuccessResponse;
import skeletons.response.UserResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

@Singleton
public class GroupController extends Controller {

    private final NormalExecutionContext normalExecutionContext;
    private GroupsService groupsService;

    @Inject
    public GroupController(GroupsService groupsService,NormalExecutionContext normalExecutionContext) {
        this.groupsService = groupsService;
        this.normalExecutionContext = normalExecutionContext;
    }

    public CompletionStage<Result> createGroup(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        CreateGroupRequest createGroupRequest = CreateGroupRequest.build(request.body().asJson());
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(groupsService.createGroup(createGroupRequest));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> addToGroup(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        AddUserToGroupRequest addUserToGroupRequest = AddUserToGroupRequest.build(request.body().asJson());
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(groupsService.addToGroup(addUserToGroupRequest));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> getGroupMembers(Long userId,Long groupId) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(groupsService.getGroupMembers(groupId,userId));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }






}
