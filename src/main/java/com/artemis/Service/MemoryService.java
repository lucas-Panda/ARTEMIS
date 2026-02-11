package com.artemis.Service;

import com.artemis.Entity.MemoryEntity;
import com.artemis.Repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService {

    private final MemoryRepository memoryRepository;

    public MemoryService(MemoryRepository memoryRepository){
        this.memoryRepository = memoryRepository;
    }

    public MemoryEntity saveMemory(String username, String content, String type){
        MemoryEntity memory = new MemoryEntity();
        memory.setUsername(username);
        memory.setContent(content);
        memory.setType(type);
        return memoryRepository.save(memory);
    }

    public List<MemoryEntity> getMemories(String username){
        return memoryRepository.findByUsername(username);
    }

}
