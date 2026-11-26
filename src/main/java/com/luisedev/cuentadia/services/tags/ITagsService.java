package com.luisedev.cuentadia.services.tags;

import com.luisedev.cuentadia.dto.requets.TagsRequest;
import com.luisedev.cuentadia.dto.response.TagsResponse;

import java.util.List;

public interface ITagsService {
    List<TagsResponse> tagsResponseList ();
    TagsResponse tagsSave(TagsRequest tagsRequest);
    boolean deletedById(Long id);
    TagsResponse tagsById(Long id);
}
