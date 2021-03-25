package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import services.MessageService;
import skeletons.request.CreateUserRequest;
import skeletons.request.MessageRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

@Singleton
public class MessageController extends Controller {

    private final NormalExecutionContext normalExecutionContext;
    private MessageService messageService;

    @Inject
    public MessageController(MessageService messageService,NormalExecutionContext normalExecutionContext) {
        this.messageService = messageService;
        this.normalExecutionContext = normalExecutionContext;
    }

    public CompletionStage<Result> sendMessage(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        MessageRequest messageRequest = MessageRequest.build(request.body().asJson());
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(messageService.sendMessage(messageRequest));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> getMessageWindow(Long fromUserId,Long receiversId,Boolean isGroupData) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            response = Json.toJson(messageService.getMessageScreen(fromUserId,receiversId,isGroupData));
            return Results.ok(response);
        },executor);
        return responseAsync;
    }

}
