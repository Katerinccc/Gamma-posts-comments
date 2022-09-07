package com.posada.santiago.gamapostsandcomments.application.bus;



import com.posada.santiago.gamapostsandcomments.application.handlers.QueueHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {

    public static final String EXCHANGE = "core-posts";
    public static final String PROXY_QUEUE_POST_CREATED = "events.proxy.post.created";
    public static final String PROXY_QUEUE_COMMENT_ADDED = "events.proxy.comment.added";

    @Autowired
    private QueueHandler handler;

    @RabbitListener(queues = PROXY_QUEUE_POST_CREATED)
    public void listenToPostCreatedQueue(String received){

        handler.acceptPostCreatedMessage(received);
    }

    @RabbitListener(queues = PROXY_QUEUE_COMMENT_ADDED)
    public void listenToCommentAddedQueue(String received){

        handler.acceptCommentAddedMessage(received);
    }

}
