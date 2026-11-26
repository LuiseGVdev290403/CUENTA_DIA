package com.luisedev.cuentadia.mappers.Tags;

import com.luisedev.cuentadia.dto.requets.TagsRequest;
import com.luisedev.cuentadia.dto.response.TagsResponse;
import com.luisedev.cuentadia.entities.Tags;

import java.util.List;

public class TagsImpl implements ITagsMapper {


    @Override
    public Tags toTagsEntity(TagsRequest tagsRequest) {
        if (tagsRequest == null) {
            return null;
        }
        return new Tags(
                tagsRequest.name()
        );
    }

    @Override
    public TagsResponse toTagsResponse(Tags tags) {
        if (tags == null) {
            return null;
        }
        return new TagsResponse(
                tags.getId(),
                tags.getName()

        );
    }

    @Override
    public List<TagsResponse> toTagsResponseList(List<Tags> tagsList) {
        return List.of();
    }
}
