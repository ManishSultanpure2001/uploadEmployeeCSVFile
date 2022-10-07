package com.postgres.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinalResponse {

	private int skippedRow;
	private int processedRow;

	@Id
	public int getSkippedRow() {
		return skippedRow;
	}
	public void setSkippedRow(int skippedRow) {
		this.skippedRow = skippedRow;
	}
	public int getProcessedRow() {
		return processedRow;
	}
	public void setProcessedRow(int processedRow) {
		this.processedRow = processedRow;
	}
	@Override
	public String toString() {
		return "FinalResponse [skippedRow=" + skippedRow + ", processedRow=" + processedRow + "]";
	}
	
}
