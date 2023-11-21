package com.example.zadanierekrut1;

import java.util.*;
import java.util.stream.Collectors;

public class Wall implements Structure{
    private List<Block> blocks;
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> resultList = new ArrayList<>();
        for (Block block : blocks)
            if(block.getMaterial().equals(material))
            {
                resultList.add(block);
            }
        return resultList;
    }
    @Override
    public int count() {
        return blocks.size();
    }
    @Override
    public String getColor() {
        Map<String, Long> colorCounts = blocks.stream()
                .map(Block::getColor)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        StringBuilder result = new StringBuilder("[\n");

        colorCounts.forEach((color , count) -> {
            double percentage = (count * 100) / blocks.size();
            result.append(String.format("%s (%.2f%%)%n", color, percentage));
        });
        result.append("]");

        return result.toString();
    }
    @Override
    public String getMaterial() {
        Map<String, Long> materialCounts = blocks.stream()
                .map(Block::getMaterial)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        StringBuilder result = new StringBuilder("[\n");

        materialCounts.forEach((material , count) -> {
            double percentage = (count * 100) / blocks.size();
            result.append(String.format("%s (%.2f%%)%n", material, percentage));
        });
        result.append("]");

        return result.toString();
    }
    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
