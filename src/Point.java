public class Point {

	public Point[] neighbours = new Point[4];
	public float[] vels = new float[4]; // clockwise directions starting from north
	public float[] newVels = new float[4];
	public float pressure;
	public float newPressure;
	public static Integer[] types = {0, 1, 2};
	int type;
	int sinInput = 0;

	public Point() {
		clear();
		type = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		for(int i = 0; i < 4; i++)
			vels[i] = 0;
		pressure = 0;
	}

	public void updateVelocity() {
		if (type == 0) {
			for (int i = 0; i < 4; i++) {
				newVels[i] = vels[i] - (neighbours[i].pressure - pressure);
			}
		}
	}

	public void updatePresure() {
		if (type == 0) {
			float eps = 0;
			for (float f : vels)
				eps += f;
			newPressure = pressure - (float) 0.5 * eps;
		}
		else if (type == 2) {
			double radians = Math.toRadians((float)sinInput/180);
			newPressure = (float) (Math.sin(radians));
			sinInput += 1;
		}
	}

	public void updateValues() {
		pressure = newPressure;
		for(int i = 0; i < 4; i++)
			vels[i] = newVels[i];
	}

	public float getPressure() {
		return pressure;
	}
}