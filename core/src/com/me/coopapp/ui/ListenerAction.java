package com.me.coopapp.ui;

public class ListenerAction implements IListenerAction {
	
	protected ListenerActionType lType;
	
	public ListenerAction(ListenerActionType _lType) {
		lType = _lType;
	}

	@Override
	public void performListenerAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListenerActionType(ListenerActionType _type) {
		lType = _type;

	}

	@Override
	public ListenerActionType getListenerActionType() {
		return lType;
	}

}
