package tickets.operations;

import tickets.ticket.*;

import java.util.ArrayList;
import java.util.List;

public class TicketOperationComposite extends TicketOperation {

	private List<TicketOperation> ticketOperationList;
	
	public TicketOperationComposite() {
		ticketOperationList = new ArrayList<>();
	}
	
	public void add(TicketOperation ticketOperation) {
		ticketOperationList.add(ticketOperation);
	}
	
	@Override
	public void set(Ticket ticket) {
		super.set(ticket);
		for (TicketOperation ticketOperation: ticketOperationList) {
			ticketOperation.set(ticket);
		}
	}
	
	@Override
	public void visit(Header head) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(head);
		}
	}

	@Override
	public void visit(SaleLine saleLine) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(saleLine);
		}
	}

	@Override
	public void visit(RepetitionLine repetitionLine) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(repetitionLine);
		}
	}

	@Override
	public void visit(CancellationLine cancellationLine) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(cancellationLine);
		}
	}

	@Override
	public void visit(ReturnLine returnLine) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(returnLine);
		}
	}

	@Override
	public void visit(Footer footer) {
		for (TicketOperation ticketOperation : ticketOperationList) {
			ticketOperation.visit(footer);
		}
	}
}
