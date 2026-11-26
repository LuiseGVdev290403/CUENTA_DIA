package com.luisedev.cuentadia.mappers.Tags;

import com.luisedev.cuentadia.dto.requets.TagsRequest;
import com.luisedev.cuentadia.dto.response.TagsResponse;
import com.luisedev.cuentadia.entities.Tags;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITagsMapper {
    Tags toTagsEntity (TagsRequest tagsRequest);
    TagsResponse toTagsResponse (Tags tags);
    List<TagsResponse> toTagsResponseList(List<Tags> tagsList);
}
