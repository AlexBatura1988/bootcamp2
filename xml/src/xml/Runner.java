package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Runner {

	public static void main(String[] args) throws IOException {
		List<Car> cars = new ArrayList<>();

		Car car1 = new Car("Mazda", "3", 2015, new LicencePlate(111, "black"));
		Car car2 = new Car("Mazda", "6", 2020, new LicencePlate(222, "white"));
		Car car3 = new Car("Opel", "Astra", 2019, new LicencePlate(333, "yellow"));

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		createListXmlCars(cars);

	}

	public static void createListXmlCars(List<Car> cars) throws IOException {

		Document doc = new Document();
		doc.setRootElement(new Element("cars"));

		for (Car car : cars) {
			Element carsElement = new Element("car");
			carsElement.setAttribute("license", String.valueOf(car.getLicencePlate()));

			carsElement.setAttribute("manufacter", String.valueOf(car.getManufacturer()));

			carsElement.setAttribute("model", String.valueOf(car.getModel()));
			carsElement.setAttribute("year", String.valueOf(car.getYear()));

			doc.getRootElement().addContent(carsElement);

		}

		XMLOutputter xmlOutput = new XMLOutputter(org.jdom2.output.Format.getCompactFormat());

		File outputFile = new File("xmlFolder/cars.xml");
		OutputStream outputStream = new FileOutputStream(outputFile);
		xmlOutput.output(doc, outputStream);

	}
	public static void parseFromXml() throws JDOMException, IOException {
			
		
	}
	

}
