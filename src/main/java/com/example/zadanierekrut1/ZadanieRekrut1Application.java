package com.example.zadanierekrut1;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ZadanieRekrut1Application {

	public static void main(String[] args) {


		// Tworzenie przykładowych bloków
		Block block1 = new BlockImpl("Red", "Wood");
		Block block2 = new BlockImpl("Blue", "Wood");
		Block block3 = new BlockImpl("Green", "Brick");
		Block block4 = new BlockImpl("Red", "Concrete");
		Block block5 = new BlockImpl("Red", "Concrete");
		Block block6 = new BlockImpl("Red", "Concrete");
		Block block7 = new BlockImpl("Red", "Concrete");
		Block block8 = new BlockImpl("Red", "Stone");

		// Tworzenie listy bloków
		List<Block> blocks = Arrays.asList(block1, block2, block3, block4, block5, block6, block7, block8);

		// Tworzenie obiektu Wall
		Wall wall = new Wall(blocks);

		// Przykładowe testy
		Optional<Block> foundBlock = wall.findBlockByColor("Red");
		System.out.println("Block with color Red: " + foundBlock.orElse(null));

		List<Block> foundBlocks = wall.findBlocksByMaterial("Wood");
		System.out.println("Blocks with material Wood: " + foundBlocks);

		System.out.println("Number of blocks: " + wall.count());

		System.out.println("Colors with percentages: " + wall.getColor());

		System.out.println("Materials with percentages: " + wall.getMaterial());


		Block block10 = new BlockImpl("Red", "Wood");
		Block block11 = new BlockImpl("Blue", "Stone");

		// Tworzenie CompositeBlock przy użyciu klasy Wall
		CompositeBlock compositeBlock = new Wall(Arrays.asList(block10, block11));

		// Wywoływanie metod z interfejsu CompositeBlock
		List<Block> blocks2 = compositeBlock.getBlocks();
		System.out.println("Blocks in the composite block: " + blocks2);

		// Możesz także korzystać z metod z interfejsu Block
		String color = compositeBlock.getColor();
		System.out.println("Color of the composite block: " + color);

		String material = compositeBlock.getMaterial();
		System.out.println("Material of the composite block: " + material);
	}
}


