package com.wileyEdge.dateTimeDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;

public class DateTimeDemo {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDateTime date2 = LocalDateTime.now();
		System.out.println(date2);
		
		LocalDate bday = LocalDate.of(1999, Month.JULY, 4);
		Period age = Period.between(bday, today);
		System.out.println(age.getYears() + " years " + age.getMonths() + " months "+ age.getDays() + " days");
		
		System.out.println("Date After 10 days: "+today.plusDays(10));
		System.out.println("Date before 10 days: "+today.minusDays(10));
		System.out.println("Date After 3 weeks: "+today.plusWeeks(3));
		System.out.println("Date before 3 weeks: "+today.minusWeeks(3));
		System.out.println("Date After 20 months: "+today.plusMonths(20));
		System.out.println("Date before 20 months: "+today.minusMonths(20));
		System.out.println("Date After 2 years: "+today.plusYears(2));
		System.out.println("Date before 2 years: "+today.minusYears(2));
		System.out.println("===============================");
		ZoneId america= ZoneId.of("Australia/Sydney");
		System.out.println(LocalDateTime.now(america));
	}
}
