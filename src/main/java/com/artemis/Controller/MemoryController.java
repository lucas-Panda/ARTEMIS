package com.artemis.Controller;

import com.artemis.Entity.MemoryEntity;
import com.artemis.Service.MemoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memory")
public class MemoryController {

    private final MemoryService memoryService;

    public MemoryController(MemoryService memoryService){
        this.memoryService = memoryService;
    }

    @PostMapping("/save")
    public MemoryEntity save(
            @RequestParam String username,
            @RequestParam String content,
            @RequestParam String type
    ){
        return memoryService.saveMemory(username, content, type);
    }

    @GetMapping("/{username}")
    public List<MemoryEntity> list(@PathVariable String username){
        return memoryService.getMemories(username);
    }

}
