import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<Notebook> note = new HashSet<>();
		Map<Integer, String> ask = new HashMap<>();
		Map<String, String> filter = new HashMap<>();
		Set<Notebook> showModels = new HashSet<>();
		Scanner scanner = new Scanner(System.in);
		note.add(new Notebook("Asser", 8, "Windows 10", "Black", 256));
		note.add(new Notebook("Acer", 16, "Windows 10", "Silver", 500));
		note.add(new Notebook("Acer", 8, "MacOS", "Grey", 800));
		note.add(new Notebook("Lenovo", 16, "Linux", "White", 1000));
		note.add(new Notebook("Asser", 8, "Windows 10", "Black", 2000));
        note.add(new Notebook("Lenovo", 8, "Windows 10", "Black", 256));
		note.add(new Notebook("Lenovo", 16, "Windows 10", "Silver", 500));
		note.add(new Notebook("MSI", 8, "MacOS", "Grey", 800));
		note.add(new Notebook("MSI", 16, "Linux", "White", 1000));
		note.add(new Notebook("MSI", 8, "Windows 10", "Black", 2000));

		ask.put(1, "model");
		ask.put(2, "ram");
		ask.put(3, "os");
		ask.put(4, "color");
		ask.put(5, "hard");

		for (Map.Entry entry : ask.entrySet()) {
			System.out.println(
					"Enter min value for filtering by " + entry.getValue() + " or press 0 if it dosen't matter: ");
			String value = scanner.nextLine();
			filter.put((String) entry.getValue(), value);
		}
		scanner.close();

		for (Notebook entry : note) {
			if ((entry.getModel().equals(filter.get("model")) || filter.get("model").equals("0")) &&
					entry.getRam() >= Integer.parseInt(filter.get("ram")) &&
					(entry.getOs().equals(filter.get("os")) || filter.get("os").equals("0")) &&
					(entry.getColor().equals(filter.get("color")) || filter.get("color").equals("0")) &&
					entry.getHard() >= Integer.parseInt(filter.get("hard"))) {
				showModels.add(entry);
			}
		}
		System.out.println("Usefull models:");
		for (Notebook notebook : showModels) {
			System.out.println(notebook);
		}
	}

}