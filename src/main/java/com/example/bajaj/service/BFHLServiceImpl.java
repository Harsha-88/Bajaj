package com.example.bajaj.service;

import com.example.bajaj.dto.RequestDTO;
import com.example.bajaj.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BFHLServiceImpl implements BFHLService {

    @Override
    public ResponseDTO processData(RequestDTO request) {

        ResponseDTO response = new ResponseDTO();

        try {
            List<String> even = new ArrayList<>();
            List<String> odd = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> special = new ArrayList<>();
            int sum = 0;
            StringBuilder alphaString = new StringBuilder();

            if (request == null || request.getData() == null) {
                response.setIs_success(false);
                response.setUser_id("harsha_shree_parashar_27122004");
                response.setEmail("harshashree230106@acropolis.in");
                response.setRoll_number("0827CS231102");
                response.setEven_numbers(even);
                response.setOdd_numbers(odd);
                response.setAlphabets(alphabets);
                response.setSpecial_characters(special);
                response.setSum("0");
                response.setConcat_string("");
                return response;
            }

            for (String item : request.getData()) {
                if (item == null || item.trim().isEmpty()) continue;
                item = item.trim();
                if (item.matches("-?\\d+")) {
                    int num = Integer.parseInt(item);
                    sum += num;
                    if (num % 2 == 0) even.add(item);
                    else odd.add(item);
                } else if (item.matches("[a-zA-Z]+")) {
                    alphabets.add(item.toUpperCase());
                    alphaString.append(item);
                } else {
                    special.add(item);
                }
            }

            String reversed = alphaString.reverse().toString();
            StringBuilder concat = new StringBuilder();
            for (int i = 0; i < reversed.length(); i++) {
                char ch = reversed.charAt(i);
                if (i % 2 == 0) concat.append(Character.toUpperCase(ch));
                else concat.append(Character.toLowerCase(ch));
            }

            response.setIs_success(true);
            response.setUser_id("harsha_shree_parashar_27122004");
            response.setEmail("harshashree230106@acropolis.in");
            response.setRoll_number("0827CS231102");
            response.setEven_numbers(even);
            response.setOdd_numbers(odd);
            response.setAlphabets(alphabets);
            response.setSpecial_characters(special);
            response.setSum(String.valueOf(sum));
            response.setConcat_string(concat.toString());

        } catch (Exception e) {
            response.setIs_success(false);
            response.setUser_id("harsha_shree_parashar_27122004");
            response.setEmail("harshashree230106@acropolis.in");
            response.setRoll_number("0827CS231102");
            response.setEven_numbers(new ArrayList<>());
            response.setOdd_numbers(new ArrayList<>());
            response.setAlphabets(new ArrayList<>());
            response.setSpecial_characters(new ArrayList<>());
            response.setSum("0");
            response.setConcat_string("");
        }

        return response;
    }
}