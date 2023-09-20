package com.sample.composetutorial.poc.utils

object AppConstants {

    var SITE_NAME_MYRX = "myrxinfo"
    var SITE_NAME_CPP = "medimpact"
    var DYNAMIC_SITE_NAME = ""
    var DEFAULT_THEME_COLOR_MYRX = "#515151"
    var DEFAULT_THEME_COLOR_CPP = "#702C91"
    const val ORG_NAME = "medimpact"
    const val CALL_FOR_SPECIALITY = "(111) 110-4354"
    const val APPLICATION_ID_CPP = "com.medimpact.cpp"
    const val ANDROID = "ANDROID"
    const val ANDROID_NATIVE = "Android ( Native )"
    const val ALIAS_NAME_KEY: String = "ALIAS_NAME"
    const val ALIAS_LEVEL_KEY:String = "ALIAS_LEVEL"

    //Prescription Status
    const val SPECIALTY = "SPECIALTY"
    const val ELIGIBLE = "ELIGIBLE"
    const val NOT_ELIGIBLE_REFILL_PROCESSING = "NOT_ELIGIBLE - REFILL PROCESSING"
    const val NOT_ELIGIBLE_CALL_FOR_REFILL = "NOT_ELIGIBLE - CALL FOR REFILL"
    const val NOT_ELIGIBLE_RECOMMENDED_REFILL_DATE = "NOT_ELIGIBLE - RECOMMENDED REFILL DATE"
    const val NOT_ELIGIBLE_REFILL_CANCELLED = "NOT_ELIGIBLE - REFILL CANCELED"
    const val AUTH_REQ_NO_REFILLS_LEFT = "AUTH_REQ - NO REFILLS LEFT"
    const val AUTH_REQ_RX_EXPIRED = "AUTH_REQ - RX EXPIRED"
    const val NOT_ELIGIBLE_PLAN_NOT_STARTED = "NOT_ELIGIBLE - PLAN NOT STARTED"
    const val NOT_ELIGIBLE_NOT_REVIEWED = "NOT_ELIGIBLE - NOT REVIEWED"
    const val NOT_ELIGIBLE_INACTIVE_OR_DISCONTINUED = "NOT_ELIGIBLE - INACTIVE/DISCONTINUED"
    const val STATUS_NULL = "STATUS_NULL"
    var HELP_CENTER_SUPPORT_MAIL = ""
    var HELP_CENTER_SUPPORT_PHONE = ""
    var HELP_CENTER_CONTENT = ""
    var SUPPRESS_HELP_CENTER_SUPPORT_MAIL = false
    const val ADD_TO_CART = "ADD TO CART"
    const val CANCEL = "Cancel"
    const val REFILL_PROCESSING = "Refill processing"
    const val REFILL_TOO_SOON = "Refill too soon"
    const val PLAN_NOT_STARTED = "Plan not started"
    const val CONTROLLED_MEDICATION = "Controlled medication"
    const val CONTROLLED_MEDICATION_MSG = "Call your Prescriber to refill"
    const val REFILL_CANCELLED = "Refill cancelled"
    const val SORT_BY = "sort_by"
    const val SHOW = "show"
    const val REFILL_STATUS = "Refill Status"
    const val DRUG = "Drug"
    const val REFILL_DATE = "Recommended Refill Date"
    const val COST = "Cost"
    const val PHARMACY_TYPE = "Pharmacy Type"
    const val ALL = "All"
    const val RECOMMENDED_REFILL = "Recommended Refill"
    const val RECOMMENDED_TO_REFILL = "Recommended to Refill"
    const val REFILLABLE_DATE = "Refillable Date"
    const val EXPIRED_OR_ZERO_REFILLS = "Expired or 0 Refills"
    const val EXPIRED_OR_NO_REFILLS = "Expired or No Refills"
    const val PID = "cpp"
    const val MEDIMPACT_DIRECT_NPI = "1831520006"
    const val MEDIMPACT_DIRECT = "BIRDI"
    const val REFILL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    const val APP_DATE_FORMAT = "MM/dd/yyyy"
    const val DOCUMENT_DATE_FORMAT = "MM-dd-yyyy"
    const val REQ_DATE_FORMAT = "yyyyMMdd"
    const val REGISTER_DATE_FORMAT = "yyyy-MM-dd"
    const val MC_CALENDAR_DATE_FORMAT = "dd-MMM-yy"
    const val MC_GRAPH_DATE_FORMAT = "yyyy-MM-dd"

    // used in calendar field( taken at ) and insert drug (createDate and Birth Control Cycle start date )
    const val MC_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS"
    const val VACCINE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    // LIFERAY RETIREMENT: these LINK_KEY_* constants are v1 content management references
    const val LINK_KEY_CONTACT_SUPPORT = "contact-support-native"
    const val LINK_KEY_MEDIMPACT_DIRECT_SUPPORT = "medimpact-direct-support"
    const val LINK_KEY_MEDIMPACT_DIRECT_SPECIALTY = "medimpact-direct-specialty"
    const val LINK_KEY_PRIVACY_POLICY = "privacy-policy"
    const val LINK_KEY_TERMS = "terms-of-use-service"
    const val LINK_KEY_DISCLAIMER = "disclaimer"
    const val LINK_KEY_IMPORTANT_CLAIM_INFORMATION = "important-claim-information"
    // These are v2 content management system references to page content. The title is considered the unique identifier across environments
    const val LINK_KEY_V2_CONTACT_SUPPORT = "Contact Support Native"
    const val LINK_KEY_V2_MEDIMPACT_DIRECT_SUPPORT = "Medimpact Direct Support"
    const val LINK_KEY_V2_MEDIMPACT_DIRECT_SPECIALTY = "Medimpact Direct Specialty"
    const val LINK_KEY_V2_PRIVACY_POLICY = "Privacy"
    const val LINK_KEY_V2_TERMS = "Terms and Conditions"
    const val LINK_KEY_V2_DISCLAIMER = "Disclaimer"
    const val LINK_KEY_V2_IMPORTANT_CLAIM_INFORMATION = "Important Claim Information"
    const val LINK_KEY_V2_HELP_FAQ = "Help - Common Questions (FAQ)"
    const val LINK_KEY_V2_HELP_GENERIC_GUIDE = "Help - Generic Drug Code"
    const val LINK_KEY_V2_HELP_GLOSSARY = "Help - Glossary Of Terms"
    const val LINK_KEY_V2_AUTOFILL_TERMS = "Auto Refill Terms And Condition"

    //    public static final String DRUG_RESULT = "DRUG_RESULT";
    const val PHARMACY_LOCATOR_DETAILS = "pharmacy_locator_details"
    const val ADDRESS = "ADDRESS"
    const val NDC = "ndc"
    const val CTA_GONE = "cta_gone"
    const val POSITION = "POSITION"
    const val SPOT = "spot"

    const val IS_MAIL_ORDER = "IS_MAILORDER"
    const val IS_MAP_ViEW = "is_map_view"
    const val IS_RETAIL_PHARMACY = "is_retail_pharmacy"
    const val IS_RETAIL_PHARMACY_MORE_LOCATION = "is_retail_pharmacy_more_location"
    const val IS_PREFERRED_PHARMACY = "is_preferred_pharmacy"
    const val IS_PREFERRED_PHARMACY_MORE_LOCATION = "is_preferred_pharmacy_more_location"
    const val IS_OVERVIEW_MORE_LOCATION = "IS_OVERVIEW_MORE_LOCATION"

    const val DRUG_PRICE_CTA = "drug_price_cta"
    const val DRUG_OVERVIEW = "DRUG_OVERVIEW"
    const val NORMAL_MAILORDER = "normal_mailorder"
    const val PRESCRIPTION_MAILORDER = "prescription_mailorder"
    const val SELECTED_MAIL_ORDER_POSITION = "selected_mail_order_position"
    const val FROM_DRUG_FILTER = "from_drug_filter"
    const val NON_MID_TRANSFER_REQUEST_CODE = 123
    const val DRUG_FILTER_STATUS_CODE = 201
    const val DRUG_OVERVIEW_STATUS_CODE = 202
    const val MULTIPLE_MAIL_ORDER_STATUS_CODE = 203
    const val DRUG_ATTRIBUTE_STATUS_CODE = 204
    const val CHANGE_PHARMACY_SEARCH_CODE = 205
    const val DPC_SAVINGS_DASHBOARD_CODE = 206
    const val DPC_INFORMATION_DASHBOARD_CODE = 207
    const val DPC_PRESCRIPTION_SAVINGS_CODE = 208
    const val DPC_MEDICINE_CHEST_DASHBOARD_CODE = 209
    const val MEDICAL_INFO_CODE = 210
    const val DPC_PRESCRIPTION_DRUG_INFO_CODE = 212
    const val DPC_PILL_IDENTIFIER_DRUG_INFO_CODE = 213
    const val DPC_VACCINE_CODE = 214
    const val DPC_PRIOR_AUTH_CODE = 215
    const val DPC_MINIMIZE_CODE = 216
    const val DPC_PHARMACY_LOCATOR_CODE = 217
    const val DRUG_INTERACTION_INFO = "drug_interaction_info"
    const val DRUG_INTERACTION = "drug_interaction"

    //Drug Price Check CTA Status
    const val ACTIVE = "Active"
    const val EXPIRED = "Expired"
    const val INACTIVE_OR_DISCONTINUED = "InActive/Discontinued"
    const val REQUEST_NEW_PRESCRIPTION = "Request New Prescription"
    const val REQUEST_A_PRESCRIPTION = "Request a Prescription"
    const val REQUEST_RX = "REQUEST RX"

    const val TRANSFER = "Transfer"
    const val TRANSFER_DESCRIPTION = "To transfer your prescription to %s you will need to call, them at %s. They will need to know the name of that drug, and the number of the pharmacy that has the prescription now."
    const val TRANSFER_A_PRESCRIPTION = "Transfer a Prescription"
    const val MID_WILL_REQUEST_DESCRIPTION = "You do not have a prescription for drug. After you add the item to your cart and send your order, we will contact your prescriber. You will not be charged for this drug until a new prescription is sent to us."
    const val IN_CART = "IN CART"
    const val FILL_HERE = "Fill Here"

    const val MAX_LENGTH_CARD_NUMBER_VISA_MASTERCARD = 23
    const val MAX_LENGTH_CARD_NUMBER_AMEX = 17
    const val CPP_MID = "CPP_MID"
    const val CPP_MID_SPECIALTY = "CPP_MID_SPECIALTY"
    const val CPP_PARTD = "CPP_PARTD"
    const val USER_TYPE_MID = "MID"
    const val USER_TYPE_MI = "MI"
    const val PROGRESS_TOWARDS_OOP = "Progress towards OOP"
    const val DEDUCTIBLE_MET = "Deductible Met"
    const val PROGRESS_TOWARDS_DEDUCTIBLE = "Progress towards Deductible"
    const val OOP_MET = "OOP Met"

    @JvmField
    var CART_COUNT = 0

    @JvmField
    var NOTIFICATION_COUNT = 0


    const val GLOSSARY_STYLE_SHEET = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">"
    const val SCREEN_NAVIGATION_FLOW = "screen_navigation_flow"
    const val PROFILE_FULFILLMENT_FLOW = "flow_incomplete_profile"
    const val FLOW_SUBMIT_ORDER_VALIDATION = "flow_submit_order_validation"
    const val LOCATED_DRUG = "LOCATED_DRUG"
    const val EXPIRES_DAYS = 45
    const val CART_REQUEST_CODE = 1001
    const val DELETED_RXS = "deleted_rxs"
    const val COLOR_REQUEST_CODE = 1002
    const val SHAPE_REQUEST_CODE = 1003
    const val PRESCRIPTION_REQUEST_CODE = 1004
    const val DRUG_SUGGESTION_REQUEST_CODE = 1005
    const val MC_CONFIRM_REQUEST_CODE = 1006
    const val MC_ADD_ANOTHER_DRUG_REQUEST_CODE = 1007
    const val MC_MANAGE_REQUEST_CODE = 1008
    const val MC_TAKEN_LATE_CODE = 1009
    const val MC_EDIT_FREQUENCY_REQUEST_CODE = 1010
    const val MC_EDIT_REMINDER_REQUEST_CODE = 1011
    const val MC_GRAPH_FILTER_REQUEST_CODE = 1012
    const val CHANGE_PHAYMACY_REQUEST_CODE = 1013
    const val REQUEST_GET_PRICING = 1014
    const val SELECTED_PRESCRIPTION = "SELECTED_PRESCRIPTION"
    const val CO_BRAND_LOGO_KEY = "Co Brand Logo"
    const val WEBSITE_LOGO = "Websitelogo"
    const val PREFERRED = "Preferred"
    const val OTHER_PHARMACIES = "Other Pharmacies"
    const val ERROR_MSG_EDIT_ADDRESS = "There was an error updating all the systems"
    const val NETWORK_ERROR_MSG = "No Internet. Please check your Internet connection and try again"
    const val PROFILE = "profile"
    const val CARDS_UNAVAILABLE = "Cards_Unavailable"
    const val CARD_EXPIRE = "Card_Expire"
    const val TAX_AVAILABLE = "Tax_available"
    const val PRESCRIPTIONS_LIST = "Prescriptions_List"
    const val CLAIMS_HISTORY = "Claims_History"
    const val PRIOR_AUTHORIZATION = "Prior_Authorization"
    const val BENEFIT_HIGHLIGHTS = "Benefit_Highlights"
    const val MEDICAL_INFO = "Medical_Info"
    const val PAYMENT_INFO = "Payment_Info"
    const val PROFILE_INFO = "Profile_Info"
    const val ORDERS_LIST = "Orders_List"
    const val BELL_NOTIFICATIONS = "Bell_Notifications"
    const val SHIPPING_ADDRESS = "Shipping_Address"
    const val NOTIFICATION_PREFERENCE = "Notification_Preference"
    const val TAX_REPORT = "Tax_Report"
    const val MEDICINE_CHEST_CTA = "Medicine_Chest"
    const val PUBLIC_DOCS_KEY = "public_docs"
    const val PRIVATE_DOCS_KEY = "private_docs"
    const val CONTENTS_KEY = "contents"
    const val CONTENTS_IMAGES_KEY = "contents_images"
    const val VACCINE = "vaccine"
    const val VACCINE_CONFIG = "vaccine_config"
    const val VERIFY_RXCLAIMS = "verify_rxclaims"
    const val VACCINE_CONTENT = "vaccine_content"
    const val UPDATE_USER_VACCINE = "update_user_vaccine"
    const val NOT_SUBMIT_ORDER = 0
    const val CARD_ON_FILE = 2
    const val OPTIONAL_CARD_ON_FILE = 6
    const val VACCINE_BANNER_CTA = "VaccineBannerCta"
    const val DEPENDENT_ACCESS = "Dependent_Access"
    const val DRUG_ALTERNATE_PRICING = "drug_alternate_pricing"
    const val PHARMACY_ALTERNATE_PRICING = "pharmacy_alternate_pricing"

    @JvmField
    var DAW_CODE = 0

    //config Key
    const val PLAN_AMOUNT = "PLAN_AMOUNT"
    const val IDCARD_DETAILS = "IDCARD_DETAILS"
    const val PHARMACY_MAILORDER_NPI = "PHARMACY_MAILORDER_NPI"
    const val SPECIALTY_DRUG_POPUP = "SPECIALTY_DRUG_POPUP"
    const val PROMOTE_PREFERRED_PHARMACIES = "PROMOTE_PREFERRED_PHARMACIES"
    const val FEATURE_SUPPRESSION = "FEATURE_SUPPRESSION"
    const val SAVE_WITH_SIMILAR_DRUGS = "SAVE_WITH_SIMILAR_DRUGS"
    const val SUPPRESS_PREFERRED_PHARMACY_FILTER = "SUPPRESS_PREFERRED_PHARMACY_FILTER"
    const val WELCOME_BANNER = "WELCOME_BANNER"
    const val DAW_CODE_DPC = "DAW_CODE_DPC"
    const val OTC_DRUG = "OTC_DRUG"
    const val GRIEVANCES_SUPPRESS = "GRIEVANCES"
    var SUPPORT_MAIL = ""
    var SUPPORT_PHONE = ""
    const val REDIRECT_POPUP_TEXT = "REDIRECT_POPUP_TEXT"
    const val COPAY_AMOUNT_PDF = "COPAY_AMOUNT_PDF"
    const val PHARMACY_LOCATOR_CUSTOM_NAME = "PHARMACY_LOCATOR_CUSTOM_NAME"
    const val BENEFIT_CARD_PLAN_NAME = "BENEFIT_CARD_PLAN_NAME"
    const val SUPPRESS_HELP_CENTER = "SUPPRESS_HELP_CENTER"
    const val SUPPRESS_PRICING = "SUPPRESS_PRICING"
    const val EFFECTIVE_DATE = "EFFECTIVE_DATE"
    const val HIDE_CHANGE_PASS = "HIDE_CHANGE_PASSWORD"
    const val NDC_GCN = "NDC_GCN"
    const val DPC_Tier_Number = "DPC_Tier_Number"
    const val HELP_CENTER_CONTENT_CUSTOMIZATION = "HELP_CENTER_CONTENT_CUSTOMIZATION"
    const val SUPPRESS_MORE_DOCUMENTS = "SUPPRESS_MORE_MENU"
    const val SUPPRESS_SAVINGS = "SUPPRESS_SAVINGS"
    const val HEALTH_ACCOUNT = "HEALTH_ACCOUNT"
    const val PROMOTE_CLOSED_DOOR_PHARMACIES = "PROMOTE_CLOSED_DOOR_PHARMACIES"
    const val ENABLE_VACCINE_MODULE = "ENABLE_VACCINE_MODULE"
    const val APPLY_UPLOAD_DOCUMENTS = "APPLY_UPLOAD_DOCUMENTS"
    const val APPLY_UPLOAD_PAGE = "APPLY_UPLOAD_PAGE"

    const val DISCLAIMERS_CUSTOMIZATION = "DISCLAIMERS_CUSTOMIZATION"
    const val AB_TESTING = "AB_TESTING"
    const val MAIL_ORDER_PHARMACY = "MAIL_ORDER_PHARMACY"
    const val DISPLAY_CUSTOM_URL = "displayCustomURL"
    const val CUSTOM_URL = "customUrl"
    const val UI_BEHAVIOUR = "uiBehaviour"
    const val SUPPRESS_PHARMACY_URL = "suppressPharmacyURL"
    const val SUPPRESS_VACCINE = "SUPPRESS_VACCINE"
    const val VACCINE_CONFIGURATION_LEVEL = "VACCINE_CONFIGURATION_LEVEL"

    @JvmField
    var storeVersion: String? = null
    var IS_REGISTRATION = "IS_REGISTRATION"
    var IS_SESSION_TIMEOUT_TOAST = "is_session_timeout_toast"
    var REFRESH_TOKEN_API_FAILED_SIGNOUT_TEXT = "session_timeout_text"
    const val CHECKED = "checked"
    const val UNCHECKED = "unchecked"
    const val LOGO_CUSTOMIZATION = "LOGO_CUSTOMIZATION"
    const val ID_CARD_LOGO_CUSTOMIZATION = "IDCARD_LOGO_CUSTOMIZATION"
    const val CONFIG_DIVIDER = "|"
    const val GENERIC_FLAG = "G"
    const val IMAGE = "image"
    const val COLOR_THEME = "COLOR_THEME"
    const val MAX_RETAIL_QTY_DAYS = "maxRetailQtydays"
    const val MAX_MAIL_ORDER_QTY_DAYS = "maxMailOrderQtydays"
    const val ZERO = "0"
    const val NAME = "name"
    const val GCN = "gcn"
    const val PILL_IDENTIFIER_RESPONSE = "Pill Identifier Response"
    const val PI_SHAPE_ITEM = "pi shape item"
    const val COMMUNICATION_FLAG = "communication_flag"
    const val USER_INFO_FULL_INFO = "user_info_full_info"
    const val USER_PROFILE_RESPONSE = "user_profile_response"
    const val ADDRESS_REQUEST_MODEL = "address_request_model"
    const val COMPLETE_MID_ACCOUNT = "complete_mid_account"
    const val YES = "YES"
    const val PRIOR_AUTH_DETAILS_ACTIVITY = "prior_auth_details_activity"
    const val DPC_MAIN_ACTIVITY = "dpc_main_activity"
    const val FROM = "from"
    const val API_REQUEST_COMPLETED = "api_request_completed"
    const val DPC_GATEWAY = "DPC_GATEWAY"
    const val FROM_SAVINGS = "FromSavings"
    const val FROM_DPC_SAVINGS = "FromDpcSavings"
    const val FROM_MORE_LOCATION = "from_more_location"
    const val ACTION = "action"
    const val PRIOR_AUTH_SIMILAR_DRUG_CTA_CLICK = "prior_auth_similar_drug_cta_click"
    const val CONTROLLED_SUBSTANCE_2 = "2"
    const val PHARMACY_SELECTED = "pharmacy_selected"
    const val IMAGE_URLS = "image_urls"
    const val SELECTED_POSITION = "selected_position"
    const val MY_PHARMACY = "My Pharmacy"
    const val FROM_INTERACTION = "FROM_INTERACTION"
    const val DRUG_INTERACTION_DETAIL = "DRUG_INTERACTION_DETAIL"
    const val TO_SCREEN = "to_screen"
    const val PRESCRIPTION_SELECTED_POSITION = "prescription_selected_position"
    const val ANALYTICS_ORIGIN = "AnalyticsOrigin"
    const val ANALYTICS_EVENT = "analytics_event"
    const val FUTURE_BENEFIT_REQUEST_CODE = 3301
    const val COMING_FROM = "coming_from"
    const val MC_SEARCH_DRUG = "mc_search_drug"
    const val MC_PRESCRIPTION_DRUG = "mc_prescription_drug"
    const val MC_PRESCRIPTION_DRUG_NAME = "mc_prescription_drug_name"
    const val MC_PRESCRIPTION_UNFORMATTED_DRUG_NAME = "mc_prescription_unformatted_dispensed_medname"
    const val MC_PRESCRIPTION_DRUG_MED_TYPE = "mc_prescription_drug_med_type"
    const val MC_ADD_DRUG = "mc_add_drug"
    const val SEARCH_OPTION = "search_option"
    const val OPTION_SEARCH_DRUG = "option_search_drug"
    const val OPTION_PRESCRIPTION_DRUG = "option_prescription_drug"
    const val ZIP_CODE = "zip_code"
    const val CHECK_PRICE_CTA_VISIBILITY = "check_price_cta_visibility"
    const val MC_DRUG_INFO = "mc_drug_info"
    const val MEDICINE_CHEST = "medicine_chest"
    const val FROM_SCREEN = "from_screen"
    const val MC_GRAPH_DRUG_LIST = "mc_graph_drug_list"
    const val MC_DRUG_DELETED = "mc_drug_deleted"
    const val MC_DRUG_CHANGED = "mc_drug_changed"
    const val MC_DRUG_ID = "mc_drug_id"
    const val MC_NAVIGATE_TO_CALENDAR = "mc_drug_added_success"
    const val MC_DRUG_ALREADY_EXISTS = "mc_drug_already_exists"
    const val MC_DRUG_NAME = "mc_drug_name"
    const val SUCCESS = "SUCCESS"
    const val AUDIT_USER_NAME = "ws_cpp_internal"
    const val DE_USER_NAME = "ws_client_internal"
    const val RX_CLAIM = "RX-CLAIM"
    const val BARCODE_REFILL_ORDER = "barcode_refill_order"
    const val LOGIN_LOGGER = "login"
    const val ALERTS_NOTIFICATION_LOGGER = "alerts notification"
    const val NEXT_STEPS = "next steps"
    const val EXPERIMENTAL_VIEW = "experimental view"
    const val CLAIMS_LOGGER = "claims"
    const val DPC_LOGGER = "dpc"
    const val SECRET = "SECRET"
    const val BENEFIT_HIGHLIGHTS_LOGGER = "benefit highlights"
    const val PROFILE_LOGGER = "profile"
    const val PASS_LOGGER = "password"
    const val REGISTRATION_LOGGER = "registration"
    const val WEB_CONTENT_LOGGER = "web content"
    const val NOTIFICATION_PREFERENCE_LOGGER = "notification preference"
    const val TAX_REPORT_LOGGER = "tax report"
    const val MEDICINE_CHEST_LOGGER = "medicine chest"
    const val MY_DOCUMENTS_LOGGER = "my documents"
    const val SELF_SERVICE_FORM_LOGGER = "self service form"
    const val AUTO_REFILL_LOGGER = "auto refill"
    const val PILL_IDENTIFIER_LOGGER = "pill identifier"
    const val TRANSFER_RX_LOGGER = "transfer rx"
    const val FEEDBACK_LOGGER = "feedback"
    const val UNIVERSAL_LINK_LOGGER = "universal link"
    const val PROFILE_VERIFICATION_LOGGER = "profile verification"
    const val BALANCE_DUE_LOGGER = "balance due"
    const val PAYMENT_LOGGER = "payment"
    const val CART_LOGGER = "cart"
    const val ORDER_HISTORY_LOGGER = "order history"
    const val PRIOR_AUTH_LOGGER = "prior auth"
    const val PRESCRIPTION_LOGGER = "prescription"
    const val PHARMACY_LOCATOR_LOGGER = "pharmacy locator"
    const val SAVINGS_LOGGER = "savings"
    const val REVAMP_FEEDBACK = "revamp feedback"
    const val DEPENDENT_SETTINGS_LOGGER = "dependent settings"
    const val DASHBOARD_SETTINGS = "Dashboard Settings"
    const val EDIT_TYPE = "edit_type"
    const val REMINDER_TYPE = "reminder_type"
    const val FREQUENCY_TYPE = "frequency_type"
    const val MC_ADD_DRUG_CLOSE = "mc_add_drug_close"
    const val MC_DRUG_INFO_REQUEST = "mc_drug_info_request"
    const val MC_UPDATE_DRUG = "mc_update_drug"
    const val MC_UPDATE_AVAILABLE = "mc_update_available"
    const val TOTAL_UNIT_COUNT = "total_unit_count"
    const val AUTO_REFILL_ON = "AUTO REFILL ON"
    const val ADD_OTHER_USERS = "Add Other Users"
    const val PHARMACY_LOCATE_RESULT = "pharmacy_locate_result"
    const val FROM_VIEW_ON_MAP_EXPAND_CLICK = "from_view_on_map_expand_click"
    const val LOAD_DPC_FROM_LOCAL = "load_dpc_from_local"
    const val MORE_LOCATIONS = "MORE LOCATIONS"
    const val VIEW_LESS = "VIEW LESS"
    const val QSDS_DIALOG_FRAGMENT_TAG = "qsds_dialog_fragment_tag"
    const val GEO_API = "geo_api"
    const val GEO_API_PATH = "https://maps.googleapis.com"

    const val DOCUMENT_TYPE_DOCUMENT = "document"
    const val DOCUMENT_TYPE_LOGO = "logo"
    const val DOCUMENT_TYPE_LINK = "link"

    const val DOCUMENT_TITLE_MEDICATION_ORDER_FORM = "Medimpact Direct Medication Order Form"
    const val DOCUMENT_TITLE_MEDICATION_ORDER_FORM_BIRDI = "Birdi Medication Order Form"

    const val DEFAULT_MAIL_ORDER_QUANTITY: Double = 90.0
    const val DEFAULT_MAIL_ORDER_DAY_SUPPLY: Int = 90
    const val DEFAULT_QUANTITY = 30.0
    const val DEFAULT_DAY_SUPPLY = 30
    const val KEY_BRAND = "brand_key"
    const val KEY_FORM = "form_key"
    const val KEY_DOSAGE = "dosage_key"
    const val KEY_SORT = "sort_key"
    const val KEY_SORT_PRICE = "sort_price"
    const val KEY_SORT_DISTANCE = "sort_distance"

     const val NS_SAVINGS = "SAVINGS"
    const val NS_PROFILE = "PROFILE"
    const val NS_ADD_MEDICAL_INFO = "MEDICAL_INFO"
    const val NS_ADD_PAYMENT = "BILLING_INFO"
    const val NS_SET_ALERTS = "ALERTS"
    const val NS_ADD_DEPENDENTS = "DEPENDENTS"
    const val NS_MEDICINE_CHEST = "MEDICINE_CHEST"
    const val NS_REFILL_PRESCRIPTION = "REFILL_PRESCRIPTION"
    const val IN_STORE_PICKUP = "In-Store Pickup"

    const val MAIL_ORDER_PRICE = "MAIL ORDER PRICE"
    const val LOCAL_PRICE = "LOCAL PRICE"
    const val MY_SAVINGS = "MY SAVINGS"
    const val FRAGMENT_LEGACY_FEEDBACK = "GENERAL FEEDBACK"
    const val FRAGMENT_AB_FEEDBACK = "EXPERIMENTAL VIEW"

    const val DPC_STATUS_COLUMN = "DPC_Status_Column"
    const val IS_STATUS_COLUMN = "isStatusColumn"
    const val IS_SUPPRESS_TIER = "isSuppressTier"
    const val IS_SUPPRESS_TIER_NUMBER = "isSuppressTierNumber"
    const val IS_SUPPRESS_FORMULARY = "isSuppressFormulary"

    const val PACKAGE = "package:"
    const val BRAND_GENERIC = "BRAND_GENERIC"
    const val SIMILAR_DRUG = "SIMILAR_DRUG"
    const val DRUG_DOSAGE = "DRUG_DOSAGE"
    const val DAYS_SUPPLY = "DAYS_SUPPLY"
    const val PREFERRED_PHARMACY = "PREFERRED_PHARMACY"
    const val CHANGE_PHARMACY = "CHANGE_PHARMACY"

    const val  LOCAL_PHARMACIES = "LOCAL PHARMACIES"
    const val  MAIL_ORDER_PHARMACIES = "MAIL ORDER PHARMACIES"
    const val  Y_CHARACTER = "Y"
    const val  N_CHARACTER = "N"
    const val MEDICAL_INFO_MAX_RECORD = "100"
    const val MEDICAL_INFO_API_VERSION = "1.0"

    const val SUGGESTION_API_DELAY : Long = 700
    const val NO_ALLERGY_REF_NUMBER : String = "00153"
    const val NO_HEALTH_CONDITIONS_REF_NUMBER : String = "0"
    const val NO_KNOWN_DRUG_ALLERGY : String = "No Known Drug Allergy"
    const val NO_REPORTED_MEDICAL_CONDITIONS : String = "No Reported Medical Conditions"
    const val NO_MEDICAL_INFO_FOUND : String = "no_medical_info_found"
    const val IS_GET_PRICE_RESULT : String = "is_get_price_result"

    const val DRUG_INFORMATION_NOT_AVAILABLE : String = "Drug information is not available for this drug, Please try again after sometime!"
    const val VACCINE_RECOMMENDED = "RECOMMENDED"
    const val VACCINE_PAST_RECOMMENDATIONS = "PAST RECOMMENDATIONS"
    const val VACCINE_ADAPTER_MODEL = "vaccine_adapter_model"
    const val CONFIG_EXTRA_MENU = "extra-menu"
    const val CONFIG_EXTRA_VALUE = "extra-value"
    const val PROMOTE_PREFERRED_CONFIGURED = "promote_preferred"
    const val PROMOTE_PREFERRED_IS_LIVE = "promote_preferred_live"

    const val IS_CPP_MID = "isCppMid"
    const val IS_CIM_ACCOUNT ="isCIMAccount"

    // LIFERAY RETIREMENT: once liferay retirement is complete, we can scan the code for this constant and clean up whats no longer needed.
    //    Ideally, this constant can be removed after clean up is complete
    // if true, use Lucida content management system; otherwise use Liferay
    const val IS_LUCIDA_ENABLED = true

    //const val DRUG_PRICE_RESPONSE_BUNDLE_KEY = "drug_price_response_bundle_key"
    //const val QUANTITY_DAYS_SUPPLY_RESPONSE_BUNDLE_KEY = "qty_days_supply_response_bundle_key"
    //const val CURRENT_PHARMACY_RESPONSE_BUNDLE_KEY = "current_pharmacy_response_bundle_key"
    const val DRUG_INTERACTION_RESPONSE_BUNDLE_KEY = "drug_interaction_response_bundle_key"
    //const val DRUG_PRICE_REQUEST_BUNDLE_KEY = "drug_price_request_bundle_key"
    //const val DRUG_REQUEST_MODEL = "drug_request_model"
    //const val DRUG_REQUEST = "DRUG_REQUEST"



    const val MM_dd_yyyy_2 ="MM/dd/yyyy"

}