package tickets.operations;

import tickets.store.Store;
import tickets.ticket.CancellationLine;
import tickets.ticket.RepetitionLine;
import tickets.ticket.ReturnLine;
import tickets.ticket.SaleLine;

public class PriceCalculatorOperation extends TicketOperation {
	
	@Override
	public void visit(SaleLine saleLine) {
		Double price = Store.instance().getPrice(saleLine.getId(), saleLine.getUnits());
		saleLine.setPrice(price);
	}

	@Override
	public void visit(RepetitionLine repetitionLine) {
		SaleLine line = (SaleLine) ticket.getLine(repetitionLine.getNumber() - 1);
		Double price = Store.instance().getPrice(line.getId(), line.getUnits());
		repetitionLine.setPrice(price);
	}

	@Override
	public void visit(CancellationLine cancellationLine) {
		SaleLine line = (SaleLine) ticket.getLine(cancellationLine.getNumber() - 1);
		Double price = Store.instance().getPrice(line.getId(), line.getUnits());
		cancellationLine.setPrice(-price);
	}

	@Override
	public void visit(ReturnLine returnLine) {
		Double price = Store.instance().getPrice(returnLine.getId(), returnLine.getUnits());
		returnLine.setPrice(-price);
	}

}
