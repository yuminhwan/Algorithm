class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z\\d-_.]", "");

        // 3단계
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // 4단계
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5단계
        // 빌 경우 5,6,7단계 한번에
        if (new_id.isBlank()) {
            return "aaa";
        }

        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 7단계
        if (new_id.length() <= 2) {
            StringBuilder sb = new StringBuilder(new_id);
            while (sb.length() < 3) {
                sb.append(new_id.charAt(new_id.length() - 1));
            }
            new_id = sb.toString();
        }
        return new_id;
    }
}