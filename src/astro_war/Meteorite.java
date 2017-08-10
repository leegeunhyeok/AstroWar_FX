package astro_war;

public class Meteorite extends Box2D {
	private final int SPEED = 6;
	private boolean meteo_living = true;
	private int LASER_DELAY = 110;
	private int meteo_MAX_HP;
	private int meteo_HP;
	private int laser_cnt = 2;

	public Meteorite(int x, int HP) {
		this.height = 130;
		this.width = 85;
		this.x = x;
		this.y = -130;
		meteo_MAX_HP = HP;
		meteo_HP = HP;
	}

	public void MoveDown(int n) {
		y += SPEED - n;
	}

	public void attacked(int damage) {
		meteo_HP -= damage;
		if (meteo_HP <= 0)
			meteo_living = false;
	}

	public boolean shootPermission() {
		LASER_DELAY--;
		if (LASER_DELAY % 30 == 0 && LASER_DELAY > 0 && laser_cnt > 0) {
			laser_cnt--;
			return true;
		}
		return false;
	}

	public int dropItem() {
		int n = (int) (Math.random() * 20) + 1;
		if (n % 4 == 0) {
			return n / 4;
		}
		return 0; // 0은 아이템 드랍 없음
	}

	public boolean getLiveStatus() {
		return meteo_living;
	}

	public int getHP() {
		return meteo_HP;
	}

	public int getMaxHP() {
		return meteo_MAX_HP;
	}
}
