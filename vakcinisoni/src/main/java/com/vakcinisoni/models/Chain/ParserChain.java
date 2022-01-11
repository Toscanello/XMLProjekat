package com.vakcinisoni.models.Chain;

import org.xmldb.api.modules.XMLResource;

public abstract class ParserChain {

    protected ParserChain next;

    public ParserChain getNext() {
        return next;
    }

    public void setNext(ParserChain next) {
        this.next = next;
    }

    public abstract Object parse(XMLResource resource);
}
