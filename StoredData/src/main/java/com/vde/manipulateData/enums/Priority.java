package com.vde.manipulateData.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "priority")
@XmlEnum
public enum Priority {

	@XmlEnumValue(value = "300") MEDIUM, @XmlEnumValue(value = "200") HIGHT, @XmlEnumValue(value = "100") LOW;

}
