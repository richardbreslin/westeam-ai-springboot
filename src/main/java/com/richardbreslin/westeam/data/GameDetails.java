package com.richardbreslin.westeam.data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDetails {

    private AppId appId;
    private Map<String, Object> unknownProperties = new HashMap<>();

    @JsonAnySetter
    public void setUnknownProperty(String key, Object value) {
        if (this.appId == null) {
            this.appId = new AppId();
            this.appId.setAppIdKey(key);
            this.appId.setAppIdValue(value);
        }
        this.unknownProperties.put(key, value);
    }

    public static class AppId {
        private String appIdKey;
        private Object appIdValue;

        public String getAppIdKey() {
            return appIdKey;
        }

        public void setAppIdKey(String appIdKey) {
            this.appIdKey = appIdKey;
        }

        public Object getAppIdValue() {
            return appIdValue;
        }

        public void setAppIdValue(Object appIdValue) {
            this.appIdValue = appIdValue;
        }
    }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        boolean success;

        @JsonProperty("data")
        public Data getData() {
            return this.data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        Data data;

    public class Achievements {
        @JsonProperty("total")
        public int getTotal() {
            return this.total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        int total;

        @JsonProperty("highlighted")
        public ArrayList<Highlighted> getHighlighted() {
            return this.highlighted;
        }

        public void setHighlighted(ArrayList<Highlighted> highlighted) {
            this.highlighted = highlighted;
        }

        ArrayList<Highlighted> highlighted;
    }

    public class Category {
        @JsonProperty("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @JsonProperty("description")
        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String description;
    }

    public class ContentDescriptors {
        @JsonProperty("ids")
        public ArrayList<Object> getIds() {
            return this.ids;
        }

        public void setIds(ArrayList<Object> ids) {
            this.ids = ids;
        }

        ArrayList<Object> ids;

        @JsonProperty("notes")
        public Object getNotes() {
            return this.notes;
        }

        public void setNotes(Object notes) {
            this.notes = notes;
        }

        Object notes;
    }

    public class Data {
        @JsonProperty("type")
        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        String type;

        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @JsonProperty("steam_appid")
        public int getSteam_appid() {
            return this.steam_appid;
        }

        public void setSteam_appid(int steam_appid) {
            this.steam_appid = steam_appid;
        }

        int steam_appid;

        @JsonProperty("required_age")
        public int getRequired_age() {
            return this.required_age;
        }

        public void setRequired_age(int required_age) {
            this.required_age = required_age;
        }

        int required_age;

        @JsonProperty("is_free")
        public boolean getIs_free() {
            return this.is_free;
        }

        public void setIs_free(boolean is_free) {
            this.is_free = is_free;
        }

        boolean is_free;

        @JsonProperty("dlc")
        public ArrayList<Integer> getDlc() {
            return this.dlc;
        }

        public void setDlc(ArrayList<Integer> dlc) {
            this.dlc = dlc;
        }

        ArrayList<Integer> dlc;

        @JsonProperty("detailed_description")
        public String getDetailed_description() {
            return this.detailed_description;
        }

        public void setDetailed_description(String detailed_description) {
            this.detailed_description = detailed_description;
        }

        String detailed_description;

        @JsonProperty("about_the_game")
        public String getAbout_the_game() {
            return this.about_the_game;
        }

        public void setAbout_the_game(String about_the_game) {
            this.about_the_game = about_the_game;
        }

        String about_the_game;

        @JsonProperty("short_description")
        public String getShort_description() {
            return this.short_description;
        }

        public void setShort_description(String short_description) {
            this.short_description = short_description;
        }

        String short_description;

        @JsonProperty("supported_languages")
        public String getSupported_languages() {
            return this.supported_languages;
        }

        public void setSupported_languages(String supported_languages) {
            this.supported_languages = supported_languages;
        }

        String supported_languages;

        @JsonProperty("header_image")
        public String getHeader_image() {
            return this.header_image;
        }

        public void setHeader_image(String header_image) {
            this.header_image = header_image;
        }

        String header_image;

        @JsonProperty("capsule_image")
        public String getCapsule_image() {
            return this.capsule_image;
        }

        public void setCapsule_image(String capsule_image) {
            this.capsule_image = capsule_image;
        }

        String capsule_image;

        @JsonProperty("capsule_imagev5")
        public String getCapsule_imagev5() {
            return this.capsule_imagev5;
        }

        public void setCapsule_imagev5(String capsule_imagev5) {
            this.capsule_imagev5 = capsule_imagev5;
        }

        String capsule_imagev5;

        @JsonProperty("website")
        public String getWebsite() {
            return this.website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        String website;

        @JsonProperty("pc_requirements")
        public PcRequirements getPc_requirements() {
            return this.pc_requirements;
        }

        public void setPc_requirements(PcRequirements pc_requirements) {
            this.pc_requirements = pc_requirements;
        }

        PcRequirements pc_requirements;

        @JsonProperty("mac_requirements")
        public MacRequirements getMac_requirements() {
            return this.mac_requirements;
        }

        public void setMac_requirements(MacRequirements mac_requirements) {
            this.mac_requirements = mac_requirements;
        }

        MacRequirements mac_requirements;

        @JsonProperty("linux_requirements")
        public LinuxRequirements getLinux_requirements() {
            return this.linux_requirements;
        }

        public void setLinux_requirements(LinuxRequirements linux_requirements) {
            this.linux_requirements = linux_requirements;
        }

        LinuxRequirements linux_requirements;

        @JsonProperty("legal_notice")
        public String getLegal_notice() {
            return this.legal_notice;
        }

        public void setLegal_notice(String legal_notice) {
            this.legal_notice = legal_notice;
        }

        String legal_notice;

        @JsonProperty("developers")
        public ArrayList<String> getDevelopers() {
            return this.developers;
        }

        public void setDevelopers(ArrayList<String> developers) {
            this.developers = developers;
        }

        ArrayList<String> developers;

        @JsonProperty("publishers")
        public ArrayList<String> getPublishers() {
            return this.publishers;
        }

        public void setPublishers(ArrayList<String> publishers) {
            this.publishers = publishers;
        }

        ArrayList<String> publishers;

        @JsonProperty("price_overview")
        public PriceOverview getPrice_overview() {
            return this.price_overview;
        }

        public void setPrice_overview(PriceOverview price_overview) {
            this.price_overview = price_overview;
        }

        PriceOverview price_overview;

        @JsonProperty("packages")
        public ArrayList<Integer> getPackages() {
            return this.packages;
        }

        public void setPackages(ArrayList<Integer> packages) {
            this.packages = packages;
        }

        ArrayList<Integer> packages;

        @JsonProperty("package_groups")
        public ArrayList<PackageGroup> getPackage_groups() {
            return this.package_groups;
        }

        public void setPackage_groups(ArrayList<PackageGroup> package_groups) {
            this.package_groups = package_groups;
        }

        ArrayList<PackageGroup> package_groups;

        @JsonProperty("platforms")
        public Platforms getPlatforms() {
            return this.platforms;
        }

        public void setPlatforms(Platforms platforms) {
            this.platforms = platforms;
        }

        Platforms platforms;

        @JsonProperty("metacritic")
        public Metacritic getMetacritic() {
            return this.metacritic;
        }

        public void setMetacritic(Metacritic metacritic) {
            this.metacritic = metacritic;
        }

        Metacritic metacritic;

        @JsonProperty("categories")
        public ArrayList<Category> getCategories() {
            return this.categories;
        }

        public void setCategories(ArrayList<Category> categories) {
            this.categories = categories;
        }

        ArrayList<Category> categories;

        @JsonProperty("genres")
        public ArrayList<Genre> getGenres() {
            return this.genres;
        }

        public void setGenres(ArrayList<Genre> genres) {
            this.genres = genres;
        }

        ArrayList<Genre> genres;

        @JsonProperty("screenshots")
        public ArrayList<Screenshot> getScreenshots() {
            return this.screenshots;
        }

        public void setScreenshots(ArrayList<Screenshot> screenshots) {
            this.screenshots = screenshots;
        }

        ArrayList<Screenshot> screenshots;

        @JsonProperty("movies")
        public ArrayList<Movie> getMovies() {
            return this.movies;
        }

        public void setMovies(ArrayList<Movie> movies) {
            this.movies = movies;
        }

        ArrayList<Movie> movies;

        @JsonProperty("recommendations")
        public Recommendations getRecommendations() {
            return this.recommendations;
        }

        public void setRecommendations(Recommendations recommendations) {
            this.recommendations = recommendations;
        }

        Recommendations recommendations;

        @JsonProperty("achievements")
        public Achievements getAchievements() {
            return this.achievements;
        }

        public void setAchievements(Achievements achievements) {
            this.achievements = achievements;
        }

        Achievements achievements;

        @JsonProperty("release_date")
        public ReleaseDate getRelease_date() {
            return this.release_date;
        }

        public void setRelease_date(ReleaseDate release_date) {
            this.release_date = release_date;
        }

        ReleaseDate release_date;

        @JsonProperty("support_info")
        public SupportInfo getSupport_info() {
            return this.support_info;
        }

        public void setSupport_info(SupportInfo support_info) {
            this.support_info = support_info;
        }

        SupportInfo support_info;

        @JsonProperty("background")
        public String getBackground() {
            return this.background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        String background;

        @JsonProperty("background_raw")
        public String getBackground_raw() {
            return this.background_raw;
        }

        public void setBackground_raw(String background_raw) {
            this.background_raw = background_raw;
        }

        String background_raw;

        @JsonProperty("content_descriptors")
        public ContentDescriptors getContent_descriptors() {
            return this.content_descriptors;
        }

        public void setContent_descriptors(ContentDescriptors content_descriptors) {
            this.content_descriptors = content_descriptors;
        }

        ContentDescriptors content_descriptors;

        @JsonProperty("ratings")
        public Ratings getRatings() {
            return this.ratings;
        }

        public void setRatings(Ratings ratings) {
            this.ratings = ratings;
        }

        Ratings ratings;
    }

    public class Dejus {
        @JsonProperty("rating")
        public String getRating() {
            return this.rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        String rating;

        @JsonProperty("descriptors")
        public String getDescriptors() {
            return this.descriptors;
        }

        public void setDescriptors(String descriptors) {
            this.descriptors = descriptors;
        }

        String descriptors;

        @JsonProperty("use_age_gate")
        public String getUse_age_gate() {
            return this.use_age_gate;
        }

        public void setUse_age_gate(String use_age_gate) {
            this.use_age_gate = use_age_gate;
        }

        String use_age_gate;

        @JsonProperty("required_age")
        public String getRequired_age() {
            return this.required_age;
        }

        public void setRequired_age(String required_age) {
            this.required_age = required_age;
        }

        String required_age;
    }

    public class Genre {
        @JsonProperty("id")
        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String id;

        @JsonProperty("description")
        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String description;
    }

    public class Highlighted {
        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @JsonProperty("path")
        public String getPath() {
            return this.path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        String path;
    }

    public class LinuxRequirements {
        @JsonProperty("minimum")
        public String getMinimum() {
            return this.minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        String minimum;

        @JsonProperty("recommended")
        public String getRecommended() {
            return this.recommended;
        }

        public void setRecommended(String recommended) {
            this.recommended = recommended;
        }

        String recommended;
    }

    public class MacRequirements {
        @JsonProperty("minimum")
        public String getMinimum() {
            return this.minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        String minimum;

        @JsonProperty("recommended")
        public String getRecommended() {
            return this.recommended;
        }

        public void setRecommended(String recommended) {
            this.recommended = recommended;
        }

        String recommended;
    }

    public class Metacritic {
        @JsonProperty("score")
        public int getScore() {
            return this.score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        int score;

        @JsonProperty("url")
        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        String url;
    }

    public class Movie {
        @JsonProperty("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @JsonProperty("thumbnail")
        public String getThumbnail() {
            return this.thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        String thumbnail;

        @JsonProperty("webm")
        public Webm getWebm() {
            return this.webm;
        }

        public void setWebm(Webm webm) {
            this.webm = webm;
        }

        Webm webm;

        @JsonProperty("mp4")
        public Mp4 getMp4() {
            return this.mp4;
        }

        public void setMp4(Mp4 mp4) {
            this.mp4 = mp4;
        }

        Mp4 mp4;

        @JsonProperty("highlight")
        public boolean getHighlight() {
            return this.highlight;
        }

        public void setHighlight(boolean highlight) {
            this.highlight = highlight;
        }

        boolean highlight;
    }

    public class Mp4 {
        @JsonProperty("480")
        public String get_480() {
            return this._480;
        }

        public void set_480(String _480) {
            this._480 = _480;
        }

        String _480;

        @JsonProperty("max")
        public String getMax() {
            return this.max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        String max;
    }

    public class PackageGroup {
        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @JsonProperty("title")
        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        String title;

        @JsonProperty("description")
        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String description;

        @JsonProperty("selection_text")
        public String getSelection_text() {
            return this.selection_text;
        }

        public void setSelection_text(String selection_text) {
            this.selection_text = selection_text;
        }

        String selection_text;

        @JsonProperty("save_text")
        public String getSave_text() {
            return this.save_text;
        }

        public void setSave_text(String save_text) {
            this.save_text = save_text;
        }

        String save_text;

        @JsonProperty("display_type")
        public int getDisplay_type() {
            return this.display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        int display_type;

        @JsonProperty("is_recurring_subscription")
        public String getIs_recurring_subscription() {
            return this.is_recurring_subscription;
        }

        public void setIs_recurring_subscription(String is_recurring_subscription) {
            this.is_recurring_subscription = is_recurring_subscription;
        }

        String is_recurring_subscription;

        @JsonProperty("subs")
        public ArrayList<Sub> getSubs() {
            return this.subs;
        }

        public void setSubs(ArrayList<Sub> subs) {
            this.subs = subs;
        }

        ArrayList<Sub> subs;
    }

    public class PcRequirements {
        @JsonProperty("minimum")
        public String getMinimum() {
            return this.minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        String minimum;

        @JsonProperty("recommended")
        public String getRecommended() {
            return this.recommended;
        }

        public void setRecommended(String recommended) {
            this.recommended = recommended;
        }

        String recommended;
    }

    public class Platforms {
        @JsonProperty("windows")
        public boolean getWindows() {
            return this.windows;
        }

        public void setWindows(boolean windows) {
            this.windows = windows;
        }

        boolean windows;

        @JsonProperty("mac")
        public boolean getMac() {
            return this.mac;
        }

        public void setMac(boolean mac) {
            this.mac = mac;
        }

        boolean mac;

        @JsonProperty("linux")
        public boolean getLinux() {
            return this.linux;
        }

        public void setLinux(boolean linux) {
            this.linux = linux;
        }

        boolean linux;
    }

    public class PriceOverview {
        @JsonProperty("currency")
        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        String currency;

        @JsonProperty("initial")
        public int getInitial() {
            return this.initial;
        }

        public void setInitial(int initial) {
            this.initial = initial;
        }

        int initial;

        @JsonProperty("final")
        public int getMyfinal() {
            return this.myfinal;
        }

        public void setMyfinal(int myfinal) {
            this.myfinal = myfinal;
        }

        int myfinal;

        @JsonProperty("discount_percent")
        public int getDiscount_percent() {
            return this.discount_percent;
        }

        public void setDiscount_percent(int discount_percent) {
            this.discount_percent = discount_percent;
        }

        int discount_percent;

        @JsonProperty("initial_formatted")
        public String getInitial_formatted() {
            return this.initial_formatted;
        }

        public void setInitial_formatted(String initial_formatted) {
            this.initial_formatted = initial_formatted;
        }

        String initial_formatted;

        @JsonProperty("final_formatted")
        public String getFinal_formatted() {
            return this.final_formatted;
        }

        public void setFinal_formatted(String final_formatted) {
            this.final_formatted = final_formatted;
        }

        String final_formatted;
    }

    public class Ratings {
        @JsonProperty("dejus")
        public Dejus getDejus() {
            return this.dejus;
        }

        public void setDejus(Dejus dejus) {
            this.dejus = dejus;
        }

        Dejus dejus;

        @JsonProperty("steam_germany")
        public SteamGermany getSteam_germany() {
            return this.steam_germany;
        }

        public void setSteam_germany(SteamGermany steam_germany) {
            this.steam_germany = steam_germany;
        }

        SteamGermany steam_germany;
    }

    public class Recommendations {
        @JsonProperty("total")
        public int getTotal() {
            return this.total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        int total;
    }

    public class ReleaseDate {
        @JsonProperty("coming_soon")
        public boolean getComing_soon() {
            return this.coming_soon;
        }

        public void setComing_soon(boolean coming_soon) {
            this.coming_soon = coming_soon;
        }

        boolean coming_soon;

        @JsonProperty("date")
        public String getDate() {
            return this.date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        String date;
    }

    public class Screenshot {
        @JsonProperty("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @JsonProperty("path_thumbnail")
        public String getPath_thumbnail() {
            return this.path_thumbnail;
        }

        public void setPath_thumbnail(String path_thumbnail) {
            this.path_thumbnail = path_thumbnail;
        }

        String path_thumbnail;

        @JsonProperty("path_full")
        public String getPath_full() {
            return this.path_full;
        }

        public void setPath_full(String path_full) {
            this.path_full = path_full;
        }

        String path_full;
    }

    public class SteamGermany {
        @JsonProperty("rating_generated")
        public String getRating_generated() {
            return this.rating_generated;
        }

        public void setRating_generated(String rating_generated) {
            this.rating_generated = rating_generated;
        }

        String rating_generated;

        @JsonProperty("rating")
        public String getRating() {
            return this.rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        String rating;

        @JsonProperty("required_age")
        public String getRequired_age() {
            return this.required_age;
        }

        public void setRequired_age(String required_age) {
            this.required_age = required_age;
        }

        String required_age;

        @JsonProperty("banned")
        public String getBanned() {
            return this.banned;
        }

        public void setBanned(String banned) {
            this.banned = banned;
        }

        String banned;

        @JsonProperty("use_age_gate")
        public String getUse_age_gate() {
            return this.use_age_gate;
        }

        public void setUse_age_gate(String use_age_gate) {
            this.use_age_gate = use_age_gate;
        }

        String use_age_gate;

        @JsonProperty("descriptors")
        public String getDescriptors() {
            return this.descriptors;
        }

        public void setDescriptors(String descriptors) {
            this.descriptors = descriptors;
        }

        String descriptors;
    }

    public class Sub {
        @JsonProperty("packageid")
        public int getPackageid() {
            return this.packageid;
        }

        public void setPackageid(int packageid) {
            this.packageid = packageid;
        }

        int packageid;

        @JsonProperty("percent_savings_text")
        public String getPercent_savings_text() {
            return this.percent_savings_text;
        }

        public void setPercent_savings_text(String percent_savings_text) {
            this.percent_savings_text = percent_savings_text;
        }

        String percent_savings_text;

        @JsonProperty("percent_savings")
        public int getPercent_savings() {
            return this.percent_savings;
        }

        public void setPercent_savings(int percent_savings) {
            this.percent_savings = percent_savings;
        }

        int percent_savings;

        @JsonProperty("option_text")
        public String getOption_text() {
            return this.option_text;
        }

        public void setOption_text(String option_text) {
            this.option_text = option_text;
        }

        String option_text;

        @JsonProperty("option_description")
        public String getOption_description() {
            return this.option_description;
        }

        public void setOption_description(String option_description) {
            this.option_description = option_description;
        }

        String option_description;

        @JsonProperty("can_get_free_license")
        public String getCan_get_free_license() {
            return this.can_get_free_license;
        }

        public void setCan_get_free_license(String can_get_free_license) {
            this.can_get_free_license = can_get_free_license;
        }

        String can_get_free_license;

        @JsonProperty("is_free_license")
        public boolean getIs_free_license() {
            return this.is_free_license;
        }

        public void setIs_free_license(boolean is_free_license) {
            this.is_free_license = is_free_license;
        }

        boolean is_free_license;

        @JsonProperty("price_in_cents_with_discount")
        public int getPrice_in_cents_with_discount() {
            return this.price_in_cents_with_discount;
        }

        public void setPrice_in_cents_with_discount(int price_in_cents_with_discount) {
            this.price_in_cents_with_discount = price_in_cents_with_discount;
        }

        int price_in_cents_with_discount;
    }

    public class SupportInfo {
        @JsonProperty("url")
        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        String url;

        @JsonProperty("email")
        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        String email;
    }

    public class Webm {
        @JsonProperty("480")
        public String get_480() {
            return this._480;
        }

        public void set_480(String _480) {
            this._480 = _480;
        }

        String _480;

        @JsonProperty("max")
        public String getMax() {
            return this.max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        String max;
    }


}
