package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.User;

import java.util.List;

public interface IContentDAO {

    Content getContenById(Long contentId);

    void contentSave(Content content);

    List<Content> getAllContents();

    Content getContentByLessonId(Long lessnId);
}
