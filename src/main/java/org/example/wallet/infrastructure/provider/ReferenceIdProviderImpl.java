package org.example.wallet.infrastructure.provider;

import org.example.wallet.application.wallet.balance.add.provider.ReferenceIdProvider;
import org.example.wallet.domain.transaction.ReferenceId;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class ReferenceIdProviderImpl implements ReferenceIdProvider {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @Override
    public ReferenceId provide() {
        final String currentTime = simpleDateFormat.format(new Date());

        String uniqueID = UUID.randomUUID().toString()
                .replace("-", "").substring(0, 8);

        String uniqueReference = currentTime + uniqueID;

        return new ReferenceId(uniqueReference);
    }
}
