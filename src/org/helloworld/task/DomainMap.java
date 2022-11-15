package org.helloworld.task;

import java.util.*;

public class DomainMap {
    public static void main(String[] args) {
        System.out.println(findSubdomains(new String[]{"domain.ru", "sub.domain.ru", "sub.super.ru", "alpha.domain.ru", "alpha.ru", "domain.com",
                "sub.sub.domain.ru", "super.alpha.ru", "a.ru", "expert.uprava-bd.ru", "new-expert.uprava-bd.ru"}));
    }

    public static Map<String, String[]> findSubdomains(String[] domains) {
        Map<String, String[]> domainsMap = new HashMap<>();
        for (String domain : domains) {
            if (domain.indexOf('.') == domain.lastIndexOf('.')) {
                domainsMap.put(domain, null);
            }
        }
        for (Map.Entry<String, String[]> domainFromMap : domainsMap.entrySet()) {
            List<String> subDomains = new ArrayList<>();
            String currentKey = domainFromMap.getKey();
            for (String domain : domains) {
                if (currentKey.equals(domain.substring(0, domain.indexOf('.'))) ||
                        currentKey.equals(domain.substring(domain.indexOf('.') + 1, domain.lastIndexOf('.')))) {
                    subDomains.add(domain);
                }
            }
            String[] subDomainsArr = new String[subDomains.size()];
            for (int i = 0; i < subDomains.size(); i++) {
                subDomainsArr[i] = subDomains.get(i);
            }
            domainsMap.put(currentKey, subDomainsArr);
        }
        return domainsMap;
    }
}
