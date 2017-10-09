package JndiHomework;

public class Food {
	public String name;
	public int money;
	public Food(String name,int money){
		this.name=name;
		this.money=money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String toString() {
		return "Food [money=" + money + ", name=" + name + "]";
	}
}
