package com.cjs.struts2.components.Component;

import java.io.IOException;
import java.io.Writer;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class Hello extends Component {
	protected String name;

	public Hello(ValueStack stack) {
		super(stack);
	}

	public boolean end(Writer writer) {
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean start(Writer writer) {
		try {

			String actualName = findString(name);

			writer.write("Hello " + actualName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean usesBody() {
		return false;
	}
}
