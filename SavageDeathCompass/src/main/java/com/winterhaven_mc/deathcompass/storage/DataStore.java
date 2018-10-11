package com.winterhaven_mc.deathcompass.storage;

import java.util.List;
import java.util.UUID;

public abstract class DataStore {

	private boolean initialized;

	DataStoreType type;

	String filename;


	/**
	 * Initialize storage
	 */
	abstract void initialize() throws Exception;

	/**
	 * Get record from datastore
	 * @param playerUUID the player UUID for the record to be retrieved
	 * @param worldName the world name for the record to be retrieved
	 * @return death record or null if no matching record
	 */
	public abstract DeathCompass getRecord(UUID playerUUID, String worldName);

	/**
	 * Store record in datastore
	 * @param deathRecord the DeathRecord to be stored
	 */
	public abstract void putRecord(DeathCompass deathRecord);

	/**
	 * get all records from datastore
	 * @return List of all DeathRecords
	 */
	abstract List<DeathCompass> getAllRecords();

	/**
	 * Delete record
	 * @param playerUUID the player uuid of the record to delete
	 * @param worldName the world name of the record to delete
	 * @return the DeathRecord that was deleted from datastore
	 */
	@SuppressWarnings("unused")
	abstract DeathCompass deleteRecord(UUID playerUUID, String worldName);

	/**
	 * Remove player from storage cache
	 * @param playerUUID player UUID to remove from storage cache
	 */
	abstract public void flushCache(UUID playerUUID);

	/**
	 * Close storage
	 */
	public abstract void close();

	abstract void save();


	@SuppressWarnings("UnusedReturnValue")
	abstract boolean delete();

	abstract boolean exists();

	String getFilename() {
		return this.filename;
	}

	@SuppressWarnings("WeakerAccess")
	public DataStoreType getType() {
		return this.type;
	}

	/**
	 * Get datastore name, formatted for display
	 * @return String containing datastore name
	 */
	@SuppressWarnings("WeakerAccess")
	public String getDisplayName() {
		return this.getType().toString();
	}

	boolean isInitialized() {
		return this.initialized;
	}

	void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

}
