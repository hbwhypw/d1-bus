package com.tmtc.vo;

import com.tmtc.po.CarLocation;

public class DistanceVo{
	private CarLocation carLocation;
	private double distance;
	public DistanceVo() {	}
	public DistanceVo(CarLocation carLocation, double distance) {
		super();
		this.carLocation = carLocation;
		this.distance = distance;
	}
	public CarLocation getCarLocation() {
		return carLocation;
	}
	public void setCarLocation(CarLocation carLocation) {
		this.carLocation = carLocation;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "DistanceVo [carLocation=" + carLocation + ", distance=" + distance + "]";
	}
}
