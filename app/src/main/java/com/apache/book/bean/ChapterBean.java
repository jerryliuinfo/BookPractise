package com.apache.book.bean;

import java.io.Serializable;

/**
 * Created by Jerry on 2018/11/21.
 */
public class ChapterBean implements Serializable {

    public static final int CHAPTER_INDEX_1 = 1;
    public static final int CHAPTER_INDEX_2 = 2;
    public static final int CHAPTER_INDEX_3 = 3;
    public static final int CHAPTER_INDEX_4 = 4;
    public static final int CHAPTER_INDEX_5 = 5;
    public static final int CHAPTER_INDEX_6 = 6;
    public static final int CHAPTER_INDEX_7 = 7;



    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_5 = 5;

    public ChapterBean(int chapterIndex, int sectionIndex, String name) {
        this.chapterIndex = chapterIndex;
        this.sectionIndex = sectionIndex;
        this.name = name;
    }

    private int chapterIndex;

    private int sectionIndex;

    private String name;

    public int getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"chapterIndex\":").append(chapterIndex);
        sb.append(",\"sectionIndex\":").append(sectionIndex);
        sb.append(",\"name\":\"").append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
