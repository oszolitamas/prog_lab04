package lab_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Iterator;

public class Main {
	private static ArrayList<Beer> beers = new ArrayList<>();
	
	public static void add(String[] b) {
		if (b.length > 1) beers.add(new Beer(b[1], b[2], Double.parseDouble(b[3])));
	}
	public static void list(String[] b) {
		if (b.length > 1) {
			if (b[1].equals("name")) {
				Collections.sort(beers, new NameComparator());
			}
			else if (b[1].equals("style")) {
				Collections.sort(beers, new StyleComparator());
			}
			if (b[1].equals("strength")) {
				Collections.sort(beers, new StrengthComparator());
			}
		}
		for (Beer bs : beers) {
			System.out.println(bs.toString());
		}
	}
	
	public static void save(String[] b) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(b[1]));
		oos.writeObject(beers);
		oos.close();
	}
	
	public static void load(String[] b) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(b[1]));
		beers = (ArrayList<Beer>) ois.readObject();
		ois.close();
	}
	
	public static void search(String[] b) {
		System.out.println("8. feladat");
		if (b.length == 2) {
			for (Beer bs : beers) {
				if (b[1].equals(bs.getName())) {
					System.out.println(bs.toString());
				}
			}
		}
		else if (b.length > 2) {
			for (Beer bs : beers) {
		        switch (b[1]) {
		            case "name":
		                if (bs.getName().equals(b[2])) System.out.println(bs.toString());
		                break;
		            case "style":
		                if (bs.getStyle().equals(b[2])) System.out.println(bs.toString());
		                break;
		            case "strength":
		                if (bs.getStrength() == Double.parseDouble(b[2])) System.out.println(bs.toString());
		                break;
		        }
		    }
		}
	}
	
	public static void find(String[] b) {
		System.out.println("8. feladat");
		if (b.length == 2) {
			for (Beer bs : beers) {
				if (bs.getName().contains(b[1])) {
					System.out.println(bs.toString());
				}
			}
		}
		else if (b.length > 2) {
			for (Beer bs : beers) {
		        switch (b[1]) {
		            case "name":
		                if (bs.getName().contains(b[2])) System.out.println(bs.toString());
		                break;
		            case "style":
		                if (bs.getStyle().contains(b[2])) System.out.println(bs.toString());
		                break;
		            case "strength":
		                if (bs.getStrength() >= Double.parseDouble(b[2])) System.out.println(bs.toString());
		                break;
		            case "weaker":
		                if (bs.getStrength() <= Double.parseDouble(b[2])) System.out.println(bs.toString());
		                break;
		        }
		    }
		}
	}
	
	public static void delete(String[] b) {
		if (b.length > 1) {
			Iterator<Beer> b_i = beers.iterator();
			while (b_i.hasNext()) {
				Beer beer = b_i.next();
				if (beer.getName().equals(b[1])) {
					b_i.remove();
					break;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Beer b1 = new Beer("Blanc", "buza", 5);
		Beer b2 = new Beer("Soproni", "lager", 4.5);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("1. feladat");
		System.out.println(b1.toString() + "; " + b2.toString());
		while (true) {
			try {
				String line = br.readLine();
				String[] inp = line.split(" ");
				if (inp.length != 1) System.out.println(inp[0] + ", " + inp.length);
				if (inp[0].equals("exit")) {
					System.out.println("2. feladat");
					System.exit(0);
				}
				else if (inp[0].equals("add")) {
					System.out.println("3. feladat");
					add(inp);
				}
				else if (inp[0].equals("list")) {
					System.out.println("5. feladat");
					list(inp);
				}
				else if (inp[0].equals("save")) {
					System.out.println("4. feladat");
					save(inp);
				}
				else if (inp[0].equals("load")) {
					System.out.println("4. feladat");
					load(inp);
				}
				else if (inp[0].equals("search")) {
					System.out.println("6. feladat");
					search(inp);
				}
				else if (inp[0].equals("find")) {
					System.out.println("6. feladat");
					find(inp);
				}
				else if (inp[0].equals("delete")) {
					System.out.println("7. feladat");
					delete(inp);
				}
			} catch (Exception e) {
				System.out.println("Sikertelen");
			}
		}
	}
}
