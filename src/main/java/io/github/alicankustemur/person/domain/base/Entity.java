package io.github.alicankustemur.person.domain.base;

import java.io.Serializable;

public interface Entity extends Serializable {

	public Long getId();

	public void setId(Long id);

}
