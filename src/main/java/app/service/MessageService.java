package app.service;

import app.entity.Message;
import app.entity.ProgrammingLang;
import app.entity.User;
import app.entity.UserMessageId;
import app.repository.MessageRepository;
import app.repository.ProgrammingLangsRepository;
import app.repository.UserRepository;

import java.util.Locale;

public class MessageService {
    public static UserRepository userRepository = new UserRepository();
    public static MessageRepository messageRepository = new MessageRepository();
    public static ProgrammingLangsRepository langsRepository = new ProgrammingLangsRepository();
    public void saveMessage(User userFrom, User userTo, String messageContent, String language){
        language = language.toLowerCase(Locale.ROOT);
        ProgrammingLang lang = langsRepository.findLangByName(language);
        Message message = new Message();
        message.setProgrammingLangMessage(lang);
        message.setUserFrom(userFrom);
        message.setUserTo(userTo);
        message.setContent(messageContent);
        message.setUserMessageId(new UserMessageId(userFrom.getId(),
                userTo.getId(), lang.getId()));
        messageRepository.saveMessage(message);
        lang.getMessages().add(message);
        langsRepository.updateLang(lang);
        userFrom.getMessagesFrom().add(message);
        userRepository.updateUser(userFrom);
        userTo.getMessagesTo().add(message);
        userRepository.updateUser(userTo);
    }

    public void deleteMessage(Message message){

    }
}
