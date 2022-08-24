package tickets.operations;

import tickets.ticket.*;
import tickets.utils.Console;

public class TaxPrinterOperation extends TicketOperation {

	@Override
	public void visit(Header header) {
		Console.instance().writeln("TaxPrinterOperation Head: " + header.getDate());
	}

	@Override
	public void visit(SaleLine saleLine) {
		Console.instance().writeln("TaxPrinterOperation: Sale " + saleLine.getId() + " - " + saleLine.getUnits() + " units : $" + saleLine.getPrice());
	}

	@Override
	public void visit(RepetitionLine repetitionLine) {
		Console.instance().writeln("TaxPrinterOperation: Repetition " + repetitionLine.getNumber() + ": $" + repetitionLine.getPrice());
	}

	@Override
	public void visit(CancellationLine cancellationLine) {
		Console.instance().writeln("TaxPrinterOperation: Cancellation " + cancellationLine.getNumber() + ": $" + cancellationLine.getPrice());
	}

	@Override
	public void visit(ReturnLine returnLine) {
		Console.instance().writeln("TaxPrinterOperation: Return " + returnLine.getId() + " - " + returnLine.getUnits() + " units : $" + returnLine.getPrice());
	}

	@Override
	public void visit(Footer footer) {
		Console.instance().writeln("TaxPrinterOperation Foot: " + footer.getTotalPrice());
	}
	
}
