package com.tmtc.vo;

import java.util.List;

import com.tmtc.po.Dictionary;

public class DictionaryVo extends Dictionary{
	private List<Dictionary> children;
	
	public List<Dictionary> getChildren() {
        return children;
    }

    public void setChildren(List<Dictionary> children) {
        this.children = children;
    }

    public DictionaryVo() {
    }

    public DictionaryVo(List<Dictionary> children) {
		super();
		this.children = children;
	}

	public DictionaryVo(Dictionary dictionary) {
        setId(dictionary.getId());
        setName(dictionary.getName());
        setCode(dictionary.getCode());
        setIs_sub(dictionary.getIs_sub());
        setSort(dictionary.getSort());
        setCity_code(dictionary.getCity_code());
        setIs_available(dictionary.getIs_available());
        setIs_check(dictionary.getIs_check());
        setRemark(dictionary.getRemark());
    }

    @Override
    public String toString() {
        return "ResourceVo{" +
                "children=" + children +
                "} " + super.toString();
    }
}
