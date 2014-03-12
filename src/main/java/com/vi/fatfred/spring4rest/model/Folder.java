package com.vi.fatfred.spring4rest.model;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * A folder with subfolders in our cloud based filesystem.
 *
 * @author armin.weisser
 */
public class Folder {

    private final String name;
    private Collection<Folder> subfolders;

    public Folder(String name) {
        this.name = name;
        subfolders = Collections.EMPTY_LIST;
    }

    public Folder(String name, String... subfolderNames) {
        this(name);
        subfolders = CollectionUtils.collect(Arrays.asList(subfolderNames), new Transformer() {
            @Override
            public Object transform(Object o) {
                return new Folder((String)o);
            }
        });
    }

    public String getName() {
        return name;
    }

    public Collection<Folder> getSubfolders() {
        return Collections.unmodifiableCollection(subfolders);
    }

    public boolean add(Folder folder) {
        return subfolders.add(folder);
    }

    public boolean delete(Folder subFolder) {
        return subfolders.remove(subFolder);
    }

    @Override
    public boolean equals(Object that) {
        return that != null && this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
