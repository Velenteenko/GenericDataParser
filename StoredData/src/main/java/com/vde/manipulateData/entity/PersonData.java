package com.vde.manipulateData.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vde.manipulateData.enums.Priority;

@XmlRootElement
public class PersonData {

	private String name;
	private long dateCreate;
	private Priority priority;

	private List<String> messages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(long dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[Name: " + name).append("DateCreate(in ms): " + dateCreate)
				.append(" Priority: " + priority.name()).append(" Messages: {");
		Integer i = messages.size();
		for (String message : messages) {
			if (i != 1) { // check last element in array
				builder.append(message + ",");
			} else {
				builder.append(message + "}");
			}
			i--;
		}
		builder.append("]");
		return builder.toString();
	}

}
