package com.example.gatewayservice.validation;

public final class ValidationPattern {
   private ValidationPattern() {}
   public static final String SENSOR_STATUS = "(NORMAL|LOADED|FAILED)";
   public static final String DATE_TIME = "^(\\d{4,})-(\\d{2})-(\\d{2})[T ](\\d{2}):(\\d{2})(?::(\\d{2}(?:\\.\\d+)?))?$";
}
