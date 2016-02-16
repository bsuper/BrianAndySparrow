// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: app/src/main/proto/sparrow.proto at 64:1
package me.bsu.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class VectorClockItem extends Message<VectorClockItem, VectorClockItem.Builder> {
  public static final ProtoAdapter<VectorClockItem> ADAPTER = new ProtoAdapter_VectorClockItem();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_UUID = "";

  public static final Integer DEFAULT_CLOCK = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String uuid;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer clock;

  public VectorClockItem(String uuid, Integer clock) {
    this(uuid, clock, ByteString.EMPTY);
  }

  public VectorClockItem(String uuid, Integer clock, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.uuid = uuid;
    this.clock = clock;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.uuid = uuid;
    builder.clock = clock;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof VectorClockItem)) return false;
    VectorClockItem o = (VectorClockItem) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(uuid, o.uuid)
        && Internal.equals(clock, o.clock);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (uuid != null ? uuid.hashCode() : 0);
      result = result * 37 + (clock != null ? clock.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (uuid != null) builder.append(", uuid=").append(uuid);
    if (clock != null) builder.append(", clock=").append(clock);
    return builder.replace(0, 2, "VectorClockItem{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<VectorClockItem, Builder> {
    public String uuid;

    public Integer clock;

    public Builder() {
    }

    public Builder uuid(String uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder clock(Integer clock) {
      this.clock = clock;
      return this;
    }

    @Override
    public VectorClockItem build() {
      if (uuid == null
          || clock == null) {
        throw Internal.missingRequiredFields(uuid, "uuid",
            clock, "clock");
      }
      return new VectorClockItem(uuid, clock, buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_VectorClockItem extends ProtoAdapter<VectorClockItem> {
    ProtoAdapter_VectorClockItem() {
      super(FieldEncoding.LENGTH_DELIMITED, VectorClockItem.class);
    }

    @Override
    public int encodedSize(VectorClockItem value) {
      return ProtoAdapter.STRING.encodedSizeWithTag(1, value.uuid)
          + ProtoAdapter.INT32.encodedSizeWithTag(2, value.clock)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, VectorClockItem value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.uuid);
      ProtoAdapter.INT32.encodeWithTag(writer, 2, value.clock);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public VectorClockItem decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.uuid(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.clock(ProtoAdapter.INT32.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public VectorClockItem redact(VectorClockItem value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
