package com.posada.santiago.gamapostsandcomments.application.handlers;

import co.com.sofka.domain.generic.DomainEvent;
import com.google.gson.Gson;
import com.posada.santiago.gamapostsandcomments.application.bus.models.CommentModel;
import com.posada.santiago.gamapostsandcomments.application.bus.models.PostModel;
import org.springframework.stereotype.Service;
import java.util.function.Consumer;

@Service
public class QueueHandler  {

    private final Gson gson = new Gson();

    public void acceptPostCreatedMessage(String received) {
        PostModel postModelReceived = gson.fromJson(received, PostModel.class);

        System.out.println(postModelReceived.toString());

    }

    public void acceptCommentAddedMessage(String received) {
        CommentModel commentReceived = gson.fromJson(received, CommentModel.class);

        System.out.println(commentReceived.toString());

    }

}
