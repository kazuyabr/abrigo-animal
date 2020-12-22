package com.contazap.abrigo_animal.util.enums;

public enum SaudeEnum {

	SAUDAVEL("SAUDAVEL"), DOENTE("DOENTE"), MORTO("MORTO");

	private final String value;

	SaudeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static SaudeEnum getEnum(String type) {
		for (SaudeEnum s : values()) {
			if (type.equals(s.getValue())) {
				return s;
			}
		}
		return null;
	}

}
