package cinemaBaibuh;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class Action implements Serializable {

	static Scanner sc = new Scanner(System.in);
	private  List<Film> listF;
	private  List<Hall> listH;
	private  List<Seassion> listS;
	
	
	public Action() throws ClassNotFoundException, IOException {
		listF = new ArrayList<>();
		listH = new ArrayList<>();
		listS = new ArrayList<>();
		
		
	}
	
	public  List<Film> getListF() {
		return listF;
	}
	public  void setListF(List<Film> listF) {
		this.listF = listF;
	}
	public  List<Hall> getListH() {
		return listH;
	}
	public  void setListH(List<Hall> listH) {
		this.listH = listH;
	}
	public  List<Seassion> getListS() {
		return listS;
	}
	public  void setListS(List<Seassion> listS) {
		this.listS = listS;
	}




	public void addFilm(){
		System.out.println("Enter the name of the movie");
		String name = sc.next();
		System.out.println("Enter the genre");
		String ganre = sc.next();
		Film f = new Film(name, ganre);

		listF.add(f);
	}
	
	public void removeFilm(){
		System.out.println("Enter the name of the movie");
		String name = sc.next();
		
		Iterator<Film> i = listF.iterator();
		while (i.hasNext()){
			Film next = i.next();
			if(next.getName().equals(name)){
				i.remove();
			}
		}
		
//		for (Film film : listF) {
//			if(film.getName().equals(name)){
//				listF.remove(film);
//			}
//		}
	}
	
	public void addHall(){
		System.out.println("Enter the number of seats");
		int countOfSit = sc.nextInt();
		System.out.println("Enter the number of hall");
		int numberOfHall = sc.nextInt();
		Hall h = new Hall(countOfSit, numberOfHall);

		listH.add(h);
	}
	
	public void removeHall(){
		System.out.println("Enter the number of hall");
		int numberOfHall = sc.nextInt();
		
		Iterator<Hall> i = listH.iterator();
		while (i.hasNext()){
			Hall next = i.next();
			if(next.getNumberOfHall()==numberOfHall){
				i.remove();
			}
		}
		
//		for (Hall h : listH) {
//			if(h.getNumberOfHall()==numberOfHall){
//				listH.remove(h);
//			}
//		}
	}
	
	public void addSeas(){
		System.out.println("Enter the name of the movie");
		String name = sc.next();
		Film film = null;
		for (Film f : listF) {
			if(f.getName().equals(name)){
				film=f;
			}
		}
		
		System.out.println("Enter the number of hall");
		int numberOfHall = sc.nextInt();
		Hall hall = null;
		for (Hall h : listH) {
			if(h.getNumberOfHall()==numberOfHall){
				hall=h;
			}
		}
		
		System.out.println("Enter date: month, day, hour");
		int month = sc.nextInt();
		int day = sc.nextInt();
		int hours = sc.nextInt();
		
		Date d = new Date();
		d.setMonth(month);
		d.setDate(day);
		d.setHours(hours);
		
		listS.add(new Seassion(hall, film, d));
		
	}
	
	public void removeSeas(){
		System.out.println("Enter the name of the movie");
		String name = sc.next();
		Film film;
		
		System.out.println("Enter the number of hall");
		int numberOfHall = sc.nextInt();
		Hall hall;
		
		Iterator<Seassion> i = listS.iterator();
		while (i.hasNext()){
			Seassion next = i.next();
			if(next.getH().getNumberOfHall()==numberOfHall && next.getF().getName().equals(name)){
				i.remove();
			}
		}
		
//		for (Seassion s : listS) {
//			if(s.getH().getNumberOfHall()==numberOfHall && s.getF().getName().equals(name)){
//				listS.remove(s);
//			}	
//		}
	}
	
	public void showFilm(){
		if(listF.isEmpty()){
			System.out.println("The list is empty");
		}else{
			for (Film film : listF) {
			System.out.println(film);
		}
		}	
	}
	
	public void showHall(){
		if(listH.isEmpty()){
			System.out.println("The list is empty");
		}else{
			for (Hall hall : listH) {
				System.out.println(hall);
			}
		}
	}
	public void showSeas(){
		if(listS.isEmpty()){
			System.out.println("The list is empty");
		}else{
			for (Seassion seas : listS) {
				System.out.println(seas);
			}
		}
	}
	
	public void showSeasByDays(){
		System.out.println("Enter day");
		int day = sc.nextInt();
		
		for (Seassion s : listS) {
			if(s.getD().getDate()==day){
				System.out.println(s);
			}
		}
	}
	
	public void showSeasByFilms(){
		System.out.println("Enter the name of the movie");
		String name = sc.next();
		
		for (Seassion s : listS) {
			if(s.getF().getName().equals(name)){
				System.out.println(s);
			}
		}
	}
	
	public void MenuForAdm() throws IOException{
		System.out.println ("");
		System.out.println ("Select an action:");
		System.out.println ("1. Add a movie:");
		System.out.println ("2. Add hall:");
		System.out.println ("3.Add Session:");
		System.out.println ("4.Delete movie:");
		System.out.println ("5. Delete the hall:");
		System.out.println ("6.Delete session:");
		System.out.println ("7. Show sessions:");
		System.out.println ("8.Show movies:");
		System.out.println ("9.Show halls:");
		System.out.println ("10.Change User:");
		System.out.println ("11. Exit the program:");
		int number = sc.nextInt();
		actionForAdm(number);
		
	}
	
	public void MenuForUser() throws IOException{
		System.out.println ("");
		System.out.println ("Select an action:");
		System.out.println ("1.Show sessions by day:");
		System.out.println ("2.Show sessions per movie:");
		System.out.println ("3.Show movie list:");
		System.out.println ("4.Change User:");
		System.out.println ("5. Exit from the program:");
		int number = sc.nextInt();
		actionForUser(number);
	}
	
	public void actionForAdm(int number) throws IOException{
		switch (number) {
		case 1:
			addFilm();
			Serelezation();
			MenuForAdm();
			break;
		case 2:
			addHall();
			Serelezation();
			MenuForAdm();
			break;
		case 3:
			addSeas();
			Serelezation();
			MenuForAdm();
			break;
		case 4:
			removeFilm();
			Serelezation();
			MenuForAdm();
			break;
		case 5:
			removeHall();
			Serelezation();
			MenuForAdm();
			break;
		case 6:
			removeSeas();
			Serelezation();
			MenuForAdm();
			break;
		case 7:
			showSeas();
			continueAdm();
			break;
		case 8:
			showFilm();
			continueAdm();
			break;
		case 9:
			showHall();
			continueAdm();
			break;
		case 10:
			choseProfile();
			break;
		case 11:
			System.exit(0);
			break;

		default:
			System.out.println("Wrong");
			MenuForAdm();
			break;
		}
		
	}
	
	public void actionForUser(int number) throws IOException{
		switch (number) {
		case 1:
			showSeasByDays();
			continueUser();
			break;
		case 2:
			showSeasByFilms();
			continueUser();
			break;
		case 3:
			showFilm();
			continueUser();
			break;
		case 4:
			choseProfile();
			break;
		case 5:
			System.exit(0);
			break;
		
		default:
			System.out.println("Wrong");
			MenuForUser();
			break;
		}
		
	}
	
	public  void choseProfile() throws IOException {
		try {
			Deserelezation();
		} catch (ClassNotFoundException | IOException e) {
			
		}
		System.out.println("Select a profile: 1. Administrator; 2. User");
		int chose = sc.nextInt();
		if(chose ==1){
			MenuForAdm();
		}
		if(chose ==2){
			MenuForUser();
		}
	}
	
    public  void Serelezation()throws IOException{
		
		FileOutputStream fos = new FileOutputStream("cinema.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(this);
		
		oos.flush();
		oos.close();	
	}
    
     public  void Deserelezation() throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream("cinema.txt");
		ObjectInputStream oin = new ObjectInputStream(fis);

		Action a = (Action) oin.readObject();
		listF = a.listF;
		listH = a.listH;
		listS = a.listS;

	}
     
     public  void continueAdm() throws IOException{
    	 System.out.println("Continue? 1. Yes; 2. No.");
    	 int chose = sc.nextInt();
 		if(chose ==1){
 			MenuForAdm();
 		}
 		if(chose ==2){
 			System.exit(0);
 		}
     }
     public  void continueUser() throws IOException{
    	 System.out.println("Continue? 1. Yes; 2. No.");
    	 int chose = sc.nextInt();
    	 if(chose ==1){
    		 MenuForUser();
    	 }
    	 if(chose ==2){
    		 System.exit(0);
    	 }
     }

	@Override
	public String toString() {
		return "Action [listF=" + listF + ", listH=" + listH + ", listS="
				+ listS + "]";
	}
     
	
}
