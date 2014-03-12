package com.vi.fatfred.spring4rest.controller;

import com.vi.fatfred.spring4rest.model.Folder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A rest controller representing a cloud based filesystem.
 * You can access your filesystem via rest api and ...
 * - list all root folders (GET /cloudspace)
 * - access folders with their subfolders (GET /cloudspace/media)
 * - add new subfolders (POST /cloudspace/documents/tutorials)
 * - remove subfolders (DELETE /cloudspace/documents/tutorials)
 *
 * @author armin.weisser
 */
@RestController
@RequestMapping(value = "/cloudspace", produces = "application/json")
public class CloudSpaceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Folder> listRootFolders() {
        return VFS_MOCK.values();
    }

    @RequestMapping(value = "/{folderName}", method = RequestMethod.GET)
    public Folder getFolder(@PathVariable String folderName) {
        return VFS_MOCK.get(folderName);
    }

    @RequestMapping(value = "/{folderName}/{subFolderName}", method = RequestMethod.POST)
    public boolean addSubFolder(@PathVariable String folderName, @PathVariable String subFolderName) {
        return getFolder(folderName).add(new Folder(subFolderName));
    }

    @RequestMapping(value = "/{folderName}/{subFolderName}", method = RequestMethod.DELETE)
    public boolean deleteSubFolder(@PathVariable String folderName, @PathVariable String subFolderName) {
        return getFolder(folderName).delete(new Folder(subFolderName));
    }

    static final Map<String, Folder> VFS_MOCK = new HashMap<String, Folder>();
    static {
        VFS_MOCK.put("media", new Folder("media", "music", "photos", "videos"));
        VFS_MOCK.put("documents", new Folder("documents", "recipies", "diary"));
        VFS_MOCK.put("projects", new Folder("projects"));
    }

}
