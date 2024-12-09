package com.achrafmoullablad.aws.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.achrafmoullablad.aws.model.Message;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SqsProducer {

    @Value("${aws.sqs.queueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;
    private final ObjectMapper objectMapper;

    public SqsProducer(AmazonSQS amazonSQSClient, ObjectMapper objectMapper) {
        this.amazonSQSClient = amazonSQSClient;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(String messageContent) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);
            Message message = new Message();
            message.setContent(messageContent);
            String jsonMessage = objectMapper.writeValueAsString(message);
            amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), jsonMessage);
        } catch (Exception e) {
            // Handle exception
        }
    }
}