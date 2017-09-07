package org.terracotta.passthrough;

import org.terracotta.entity.ClientSourceId;
import org.terracotta.entity.InvokeContext;

public class PassThroughServerInvokeContext implements InvokeContext {
  private final long current;
  private final long oldest;
  private final ClientSourceId sourceId;
  private final int concurrencyKey;

  public PassThroughServerInvokeContext(ClientSourceId sourceId, int concurrencyKey, long current, long oldest) {
    this.sourceId = sourceId;
    this.current = current;
    this.oldest = oldest;
    this.concurrencyKey = concurrencyKey;
  }

  @Override
  public ClientSourceId getClientSource() {
    return sourceId;
  }

  @Override
  public long getCurrentTransactionId() {
    return current;
  }

  @Override
  public long getOldestTransactionId() {
    return oldest;
  }

  @Override
  public boolean isValidClientInformation() {
    return current >= 0;
  }

  @Override
  public ClientSourceId makeClientSourceId(long l) {
    return new PassthroughClientSourceId(l);
  }

  @Override
  public int getConcurrencyKey() {
    return concurrencyKey;
  }

}
