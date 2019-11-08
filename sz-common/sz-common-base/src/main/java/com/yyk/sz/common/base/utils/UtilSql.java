package com.yyk.sz.common.base.utils;

import org.apache.commons.lang3.StringUtils;

public enum UtilSql {
	LLIKE("%s%%"), RLIKE("%%%s"), MLIKE("%%%s%%");

	private String _template;

	UtilSql(String template) {
		this._template = template;
	};

	public String getConditaion(String value) {
		if (StringUtils.isBlank(value)) {
			return StringUtils.EMPTY;

		}
		return String.format(_template, value);
	}

}
