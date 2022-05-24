import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		ElectricEngine me1 = new ElectricEngine("Magnetic Protection IP54",20, 700, 40, 20);
		ElectricEngine me2 = new ElectricEngine("Vectorial Brusatori Protection VL132X",25, 800, 30, 25);
		ElectricEngine me3 = new ElectricEngine("Vectorial Brusatori Protection VL315L",30, 900, 45, 30);
		CombustionEngine mc1 = new CombustionEngine("Volkswagen 1.5 TFSI de 150 CV",150, 5000, 150, 1500, 5.6f);
		CombustionEngine mc2 = new CombustionEngine("BMW PHEV xDrive25e X1",220, 8700,190, 1700, 3.9f);
		CombustionEngine mc3 = new CombustionEngine("Ford Gasolina 1.0 EcoBoost 125 CV",120, 4300, 150, 1350, 3.5f);
		Wheel w1 = new Wheel("Michelin Pilot Sport 5",100,20,65);
		Wheel w2 = new Wheel("Pirelli Suv Scorpion R19",88,23,65);
		Wheel w3 = new Wheel("Goodyear Efficient Grip Performance 195-65 ",75,25,85);
		Wheel w4 = new Wheel("Bridgestone Trail Wing TW202 ",84,39,15);
		ArrayList<Wheel> aw1 = new ArrayList<Wheel>();
		for (int i=0; i<4 ; i++) {
		aw1.add(w1);
		}
		ArrayList<Wheel> aw2 = new ArrayList<Wheel>();
		for (int i=0; i<4 ; i++) {
		aw2.add(w2);
		}
		Battery b1 = new Battery("Battery Moto Yuasa",34,150,12);
		Battery b2 = new Battery("Battery Moto Bosch Yb5lb",29,160,12);
		Battery b3 = new Battery("Battery Optima Redtop Rtc42",198,650,12);
		Battery b4 = new Battery("Battery Tudor 55ah",80,475,12);
		CombustionVehicle cv1 = new CombustionVehicle("Seat Arroba", 4, 9000, mc1, 50);
		cv1.setWheels(aw1);
		CombustionVehicle cv2 = new CombustionVehicle("Ford Apofis", 4, 11000, mc3, 54);
		cv2.setWheels(aw2);
		ElectricVehicle ev1 = new ElectricVehicle("BMW Serie 200",4, 14000, me1,30);
		ArrayList<Wheel> aw3 = new ArrayList<Wheel>();
		for (int i=0; i<4 ; i++) {
		aw3.add(w3);
		}
		ev1.setWheels(aw3);
		ArrayList<Battery> ab3 = new ArrayList<Battery>();
		for (int i=0; i<4 ; i++) {
		ab3.add(b1);
		}
		ev1.setBatteries(ab3);
		ElectricVehicle ev2 = new ElectricVehicle("Honda TZR",2, 8000, me2,10);
		ev2.addWheels(w4);
		ev2.addWheels(w4);
		ArrayList<Battery> ab4 = new ArrayList<Battery>();
		for (int i=0; i<4 ; i++) {
		ab4.add(b3);
		}
		ev2.setBatteries(ab4);
		ArrayList<MotorizedVehicle> vehiculos = new ArrayList<MotorizedVehicle>();
		vehiculos.add(cv1);
		vehiculos.add(cv2);
		vehiculos.add(ev1);
		vehiculos.add(ev2);
		System.out.println("Vehiculos ordenados por velocidad maxima motores");
		System.out.println("");
		Collections.sort(vehiculos, new sortbyVelocityEngine());
		for (MotorizedVehicle motorizedVehicle : vehiculos) {
			System.out.println(motorizedVehicle);
			
		}
		System.out.println("------------------------");
		System.out.println("Vehiculos ordenados por precio total");
		System.out.println("");
		Collections.sort(vehiculos);
		for (MotorizedVehicle motorizedVehicle : vehiculos) {
			System.out.println(motorizedVehicle);
		}
		System.out.println("-------------------");
	}

}
abstract class Engine{
	
	private String model;
	private int power;
	private int basePrice;
	private int maxSpeed;
	
	public Engine(String model, int power, int basePrice, int maxSpeed) {
		super();
		this.model = model;
		this.power = power;
		this.basePrice = basePrice;
		this.maxSpeed = maxSpeed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	
}

class ElectricEngine extends Engine{
	
	private int consumption;

	public ElectricEngine(String model, int power, int basePrice, int maxSpeed, int consumption) {
		super(model, power, basePrice, maxSpeed);
		this.consumption = consumption;
	}

	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}

	public String toString() {
		return "Electric Engine\n****************\nModel = " + getModel() + "\nPower = "+ getPower() + "\nMax Speed = "+getMaxSpeed() + "\nConsumption = "+getConsumption() + "\nPrice = "+getBasePrice();
	}
	
	
	
}

class CombustionEngine extends Engine{

	private float consumption;
	private int engineDisplacement;
	
	public CombustionEngine(String model, int power, int basePrice, int maxSpeed, int engineDisplacement, float consumption) {
		super(model, power, basePrice, maxSpeed);
		this.engineDisplacement = engineDisplacement;
		this.consumption = consumption;
		
	}

	public float getConsumption() {
		return consumption;
	}

	public void setConsumption(float consumption) {
		this.consumption = consumption;
	}

	public int getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public String toString() {
		return "Combustion Engine\n****************\nModel = "+getModel() + "\nPower = "+getPower() + "\nEngine Displacement = "+getEngineDisplacement() + "\nMax Speed = "+getMaxSpeed() + "\nConsumption = "+getConsumption() + "\nPrice = "+getBasePrice();
	}
	
	
	
	
	
}
class Wheel{
	
	private String model;
	private int basePrice;
	private int radio;
	private int thickness;
	
	public Wheel(String model, int basePrice, int radio, int thickness) {
		super();
		this.model = model;
		this.basePrice = basePrice;
		this.radio = radio;
		this.thickness = thickness;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public String toString() {
		return "Wheel\n****************\nModel = "+getModel() + "\nRadio = "+getRadio()+"; Thickness = "+getThickness() + "; Price = "+getBasePrice()+"\n\n";
	}
	
	
	
	
	
}
class Battery{
	
	private String model;
	private int basePrice;
	private int capacity;
	private int power;
	private int batteryLevel;
	
	public Battery(String model, int basePrice, int capacity, int power) {
		super();
		this.model = model;
		this.basePrice = basePrice;
		this.capacity = capacity;
		this.power = power;
		this.batteryLevel = 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public String toString() {
		return "Battery\n****************\nModel = "+getModel()+"\nPower = "+getPower()+"; Capacity = "+getCapacity()+"; Battery Level = "+getBatteryLevel()+"; Price = "+getBasePrice()+"\n\n";
	}
	
	
	
	
	
}
abstract class MotorizedVehicle implements Comparable<MotorizedVehicle>{
	
	private String model;
	private int numWheels;
	private int basePrice;
	private ArrayList<Wheel> wheels;
	private Engine engine;
	
	public MotorizedVehicle(String model, int numWheels, int basePrice) {
		super();
		this.model = model;
		this.numWheels = numWheels;
		this.basePrice = basePrice;
		wheels = new ArrayList<Wheel>();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	

	private boolean grosorRadioIguales;
	public void setWheels(ArrayList<Wheel> wheels) {
		grosorRadioIguales = true;
		if (wheels.size() <= getNumWheels()) {
			for (int i = 0; i < wheels.size(); i++) {
				for (int j = 0; i < wheels.size(); i++) {
					if (wheels.get(i).getRadio() != wheels.get(j).getRadio()) {
						grosorRadioIguales = false;
					}
					else if (wheels.get(i).getThickness() != wheels.get(j).getThickness()) {
						grosorRadioIguales = false;
					}
				}
			}
		}
		if (grosorRadioIguales == false) {
			System.out.println("Radio y grosor de todas las ruedas no son iguales");
		}
		else if (grosorRadioIguales == true) {
			this.wheels = wheels;
		}
		else {
			System.out.println("No se pueden añadir más ruedas ya que ya tenemos las suficientes");
		}
		
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public abstract int getPrice();
	
	private boolean radioGrosorIguales;
	
	public void addWheels(Wheel w) {
		radioGrosorIguales = true;
		if (wheels.size() <= getNumWheels()) {
			for (int i = 0; i < wheels.size(); i++) {
				for (int j = 0; i < wheels.size(); i++) {
					if (wheels.get(i).getRadio() != wheels.get(j).getRadio()) {
						radioGrosorIguales = false;
					}
					else if (wheels.get(i).getThickness() != wheels.get(j).getThickness()) {
						radioGrosorIguales = false;
					}
				}
			}
		}
		if (radioGrosorIguales == false) {
			System.out.println("Radio y grosor de todas las ruedas no son iguales");
		}
		else if (radioGrosorIguales == true) {
			wheels.add(w);
		}
		else {
			System.out.println("No se pueden añadir más ruedas ya que ya tenemos las suficientes");
		}
		
	}
	
	public ArrayList<Wheel> getWheels() {
		return wheels;
	}

}
class CombustionVehicle extends MotorizedVehicle implements FillTank{ 
	
	private int tankCapacity;
	private int tankLevel;
	private CombustionEngine engine;
	
	public CombustionVehicle(String model, int numWheels, int basePrice, CombustionEngine engine, int tankCapacity) {
		super(model, numWheels, basePrice);
		this.engine = engine;
		this.tankCapacity = 0;
	}
	
	public int getTankCapacity() {
		return tankCapacity;
	}



	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}



	public int getTankLevel() {
		return tankLevel;
	}



	public void setTankLevel(int tankLevel) {
		this.tankLevel = tankLevel;
	}

	
	
	private int priceWheels;
	private String cadena;
	public String toString() {
		String cadena = "";
		priceWheels = 0;
		for (int i = 0; i < getWheels().size(); i++) {
			cadena += getWheels().get(i).toString();
			priceWheels += getWheels().get(i).getBasePrice();
		}
		return "###################\nCombustion Vehicle\n###################\nModel = "+getModel() + "\n\nBase Price = "+getBasePrice() + "\n\n" + engine.toString() + "\n\n" + "Wheels\n\n" + cadena + "\n\nTotal Price = "+getPrice();
	}
	
	public int getPrice() {
		return (getBasePrice()+engine.getBasePrice()+priceWheels);
	}

	public void filltank() {
		setTankLevel(100);
		
	}

	
	public int compareTo(MotorizedVehicle o) {
		return this.getPrice()-o.getPrice();
	}

	public CombustionEngine getEngine() {
		return engine;
	}

	public void setEngine(CombustionEngine engine) {
		this.engine = engine;
	}

}
class ElectricVehicle extends MotorizedVehicle implements ChargeBattery{

	private int numMaxBatterys;
	private int batteryLevel;
	private ArrayList<Battery> batteries;
	private ElectricEngine engine;
	
	public ElectricVehicle(String model, int numWheels, int basePrice, ElectricEngine engine, int numMaxBatterys) {
		super(model, numWheels, basePrice);
		this.engine = engine;
		this.numMaxBatterys = numMaxBatterys;
		this.batteryLevel = 0;
	}
	
	public int getNumMaxBatterys() {
		return numMaxBatterys;
	}

	public void setNumMaxBatterys(int numMaxBatterys) {
		this.numMaxBatterys = numMaxBatterys;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public ArrayList<Battery> getBatteries() {
		return batteries;
	}

	public void setBatteries(ArrayList<Battery> batteries) {

		if (batteries.size() < numMaxBatterys) {
			this.batteries = batteries;
		}
		else {
			System.out.println("No se pueden mas baterias");
		}
		
		
		
	}

	public ElectricEngine getEngine() {
		return engine;
	}

	public void setEngine(ElectricEngine engine) {
		this.engine = engine;
	}
	
	public void addBatery(Battery b) {
		
		if (batteries.size() < numMaxBatterys) {
			batteries.add(b);
		}
		else {
			System.out.println("No se pueden añadir mas baterias");
		}
		
	}
	
	private int sumaNiveles;
	public float getMediaBatteryLevel() {
		for (int i = 0; i < batteries.size();i++) {
			sumaNiveles += batteries.get(i).getBatteryLevel();
		}
		return sumaNiveles/batteries.size();
	}
	
	
	
	
	
	private String cadena;
	private String cadena2;
	private int precioRuedas;
	private int precioBaterias;
	public String toString() {
		cadena = "";
		cadena2 = "";
		precioRuedas = 0;
		precioBaterias = 0;
		for (int i = 0; i < getWheels().size();i++) {
			cadena += getWheels().get(i).toString();
			precioRuedas += getWheels().get(i).getBasePrice();
		}
		for (int i = 0; i < getBatteries().size();i++) {
			cadena2 += getBatteries().get(i).toString();
			precioBaterias += getBatteries().get(i).getBasePrice();
		}
		return "##################\nElectric Vehicle\n#################\nModel = "+getModel()+"\n\nBase Price = "+getBasePrice()+"\n\n" + engine.toString() +"\n\n Wheels\n\n" + cadena + "\n\nBatteries\n\n"+cadena2 + "\n\nTotal Price = "+getPrice();
	}

	public int getPrice() {
		return (getBasePrice()+engine.getBasePrice()+precioBaterias+precioRuedas);
	}

	public void chargeBattery() {
		setBatteryLevel(100);
	}

	public int compareTo(MotorizedVehicle o) {
		return this.getPrice()-o.getPrice();
	}

	
	
	
}
interface ChargeBattery{
	public void chargeBattery();
}
interface FillTank{
	public void filltank();
}

class sortbyVelocityEngine implements Comparator<MotorizedVehicle>{
	
	public int compare(MotorizedVehicle o1, MotorizedVehicle o2) {
		return o1.getEngine().getMaxSpeed()-o2.getEngine().getMaxSpeed();
	}
	
}

