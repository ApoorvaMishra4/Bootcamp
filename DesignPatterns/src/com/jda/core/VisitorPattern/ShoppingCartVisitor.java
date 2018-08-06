package com.jda.core.VisitorPattern;

public interface ShoppingCartVisitor {
    int visit(Book book);

    int visit(Fruit fruit);
}
