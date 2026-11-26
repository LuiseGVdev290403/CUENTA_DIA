package com.luisedev.cuentadia.services.tags;

import com.luisedev.cuentadia.dto.requets.TagsRequest;
import com.luisedev.cuentadia.dto.response.TagsResponse;
import com.luisedev.cuentadia.entities.Tags;
import com.luisedev.cuentadia.mappers.Tags.ITagsMapper;
import com.luisedev.cuentadia.repository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements ITagsService{
    private final ITagsMapper iTagsMapper;
    private final TagsRepository tagsRepository;

    public TagsServiceImpl(ITagsMapper iTagsMapper, TagsRepository tagsRepository) {
        this.iTagsMapper = iTagsMapper;
        this.tagsRepository = tagsRepository;
    }

    @Override
    public List<TagsResponse> tagsResponseList() {
        List<Tags> tags = tagsRepository.findAll();
        return iTagsMapper.toTagsResponseList(tags);
    }

    @Override
    public TagsResponse tagsSave(TagsRequest tagsRequest) {
        Tags tags = iTagsMapper.toTagsEntity(tagsRequest);
        Tags tagsSave = tagsRepository.save(tags);
        return iTagsMapper.toTagsResponse(tagsSave);
    }

    @Override
    public boolean deletedById(Long id) {
        if (tagsRepository.existsById(id)) {
            tagsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public TagsResponse tagsById(Long id) {
        Tags tags = tagsRepository.findById(id).orElseThrow(()-> new RuntimeException("Tags not exits"));
        return iTagsMapper.toTagsResponse(tags);
    }
}
