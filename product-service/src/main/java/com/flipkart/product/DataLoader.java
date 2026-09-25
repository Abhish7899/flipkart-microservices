package com.flipkart.product;

import com.flipkart.product.model.Product;
import com.flipkart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        productRepository.deleteAll();

        productRepository.saveAll(List.of(
            // ─────────────── MOBILES ───────────────
            Product.builder().name("Samsung Galaxy S24 Ultra 5G (Titanium Gray, 256 GB, 12 GB RAM)")
                .brand("Samsung").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("134999")).discountedPrice(new BigDecimal("99999"))
                .imageUrl("https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=600&auto=format&fit=crop&q=80")
                .description("• 12 GB RAM | 256 GB ROM | Snapdragon 8 Gen 3\n• 17.27 cm (6.8 inch) Dynamic AMOLED 2X Display (120Hz)\n• 200MP + 50MP + 12MP + 10MP Quad Rear Camera | 12MP Front Camera\n• 5000 mAh Battery with 45W Fast Charging | S-Pen Included\n• 1 Year Brand Warranty for Phone and 6 Months for In-Box Accessories")
                .rating(4.8).reviewCount(24850).build(),

            Product.builder().name("Apple iPhone 15 Pro Max (Natural Titanium, 256 GB)")
                .brand("Apple").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("159900")).discountedPrice(new BigDecimal("139900"))
                .imageUrl("https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=600&auto=format&fit=crop&q=80")
                .description("• 256 GB ROM | Super Retina XDR 120Hz ProMotion OLED\n• 17.02 cm (6.7 inch) Display with Dynamic Island\n• 48MP Main + 12MP Ultra-wide + 12MP 5x Telephoto | 12MP TrueDepth Front\n• A17 Pro Chip with 6-core GPU | Action Button | USB-C 3.0\n• 1 Year Apple Manufacturer Warranty")
                .rating(4.9).reviewCount(38200).build(),

            Product.builder().name("Apple iPhone 15 (Blue, 128 GB)")
                .brand("Apple").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("79900")).discountedPrice(new BigDecimal("65999"))
                .imageUrl("https://images.unsplash.com/photo-1510557880182-3d4d3cba35a5?w=600&auto=format&fit=crop&q=80")
                .description("• 128 GB ROM | 15.49 cm (6.1 inch) Super Retina XDR Display\n• 48MP Main + 12MP Ultra Wide Camera | 12MP Front Camera\n• A16 Bionic Chip with 5-core GPU | Dynamic Island | USB-C\n• Ceramic Shield front, colour-infused glass back\n• 1 Year Apple Warranty")
                .rating(4.7).reviewCount(45100).build(),

            Product.builder().name("OnePlus 12 5G (Flowy Emerald, 512 GB, 16 GB RAM)")
                .brand("OnePlus").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("69999")).discountedPrice(new BigDecimal("57999"))
                .imageUrl("https://images.unsplash.com/photo-1592899677977-9c10ca588bbd?w=600&auto=format&fit=crop&q=80")
                .description("• 16 GB RAM | 512 GB Storage | 4th Gen Hasselblad Camera\n• 17.32 cm (6.82 inch) 2K 120Hz ProXDR Display with Dolby Vision\n• 50MP Sony LYT-808 + 64MP Periscope + 48MP Ultra-wide\n• Snapdragon 8 Gen 3 | 5400 mAh Battery | 100W SUPERVOOC Charger in Box")
                .rating(4.7).reviewCount(14900).build(),

            Product.builder().name("OnePlus Nord CE 4 5G (Dark Chrome, 128 GB, 8 GB RAM)")
                .brand("OnePlus").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("24999")).discountedPrice(new BigDecimal("19999"))
                .imageUrl("https://images.unsplash.com/photo-1580910051074-3eb694886505?w=600&auto=format&fit=crop&q=80")
                .description("• 8 GB RAM | 128 GB ROM (Expandable up to 1 TB)\n• 17.02 cm (6.7 inch) 120Hz AMOLED Display with HDR10+\n• 50MP Sony LYT-600 with OIS + 8MP Ultra-wide | 16MP Front\n• Qualcomm Snapdragon 7 Gen 3 Processor | 5500 mAh Battery with 100W Fast Charging")
                .rating(4.5).reviewCount(31200).build(),

            Product.builder().name("Google Pixel 8 Pro (Bay Blue, 128 GB, 12 GB RAM)")
                .brand("Google").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("106999")).discountedPrice(new BigDecimal("84999"))
                .imageUrl("https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=600&auto=format&fit=crop&q=80")
                .description("• 12 GB RAM | 128 GB ROM | Google Tensor G3 Processor\n• 17.02 cm (6.7 inch) Super Actua LTPO OLED 120Hz Display\n• 50MP Main OIS + 48MP Ultra-wide Macro + 48MP 5x Telephoto\n• Best Take, Magic Editor, Audio Magic Eraser & 7 Years of Updates")
                .rating(4.6).reviewCount(9300).build(),

            Product.builder().name("Realme 12 Pro+ 5G (Submarine Blue, 256 GB, 12 GB RAM)")
                .brand("Realme").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("33999")).discountedPrice(new BigDecimal("27999"))
                .imageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=600&auto=format&fit=crop&q=80")
                .description("• 12 GB RAM | 256 GB ROM | Snapdragon 7s Gen 2 Processor\n• 64MP Periscope Portrait Camera with 3X Optical Zoom + 50MP Sony IMX890 OIS\n• 17.02 cm (6.7 inch) 120Hz Curved Vision AMOLED Display\n• 5000 mAh Battery with 67W SUPERVOOC Charge | Luxury Watch Design")
                .rating(4.4).reviewCount(18700).build(),

            Product.builder().name("Redmi Note 13 Pro+ 5G (Fusion Purple, 256 GB, 12 GB RAM)")
                .brand("Xiaomi").category("Mobiles").subCategory("Smartphones")
                .price(new BigDecimal("35999")).discountedPrice(new BigDecimal("28999"))
                .imageUrl("https://images.unsplash.com/photo-1567581935884-3349723552ca?w=600&auto=format&fit=crop&q=80")
                .description("• 12 GB RAM | 256 GB ROM | MediaTek Dimensity 7200-Ultra\n• 200MP OIS Flagship Ultra-clear Camera + 8MP Ultra-wide + 2MP Macro\n• 16.94 cm (6.67 inch) 1.5K 120Hz Curved AMOLED 3D Display\n• 120W HyperCharge (100% in 19 mins) | IP68 Water and Dust Resistant")
                .rating(4.4).reviewCount(26400).build(),

            // ─────────────── LAPTOPS ───────────────
            Product.builder().name("Apple MacBook Air M3 (15.3-inch, 16GB Unified RAM, 512GB SSD, Midnight)")
                .brand("Apple").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("154900")).discountedPrice(new BigDecimal("134900"))
                .imageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=600&auto=format&fit=crop&q=80")
                .description("• Apple M3 chip with 8-core CPU and 10-core GPU\n• 16 GB Unified Memory | 512 GB Fast SSD Storage\n• 38.91 cm (15.3 inch) Liquid Retina Display with True Tone\n• Up to 18 Hours Battery Life | 1080p FaceTime HD Camera\n• MagSafe 3, Two Thunderbolt Ports, Touch ID")
                .rating(4.9).reviewCount(18500).build(),

            Product.builder().name("Apple MacBook Pro M3 Max (16-inch, 36GB RAM, 1TB SSD, Space Black)")
                .brand("Apple").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("349900")).discountedPrice(new BigDecimal("319900"))
                .imageUrl("https://images.unsplash.com/photo-1611186871348-b1ce696e52c9?w=600&auto=format&fit=crop&q=80")
                .description("• M3 Max chip with 14-core CPU and 30-core GPU\n• 36 GB Unified RAM | 1 TB Extreme Speed SSD\n• 41.05 cm (16.2 inch) Liquid Retina XDR 120Hz Display\n• Up to 22 Hours Battery Life | HDMI port, SDXC card slot, 3x Thunderbolt 4")
                .rating(5.0).reviewCount(6100).build(),

            Product.builder().name("Dell XPS 15 9530 Intel Core i9 (32GB DDR5 / 1TB SSD / 8GB RTX 4070 / 3.5K OLED Touch)")
                .brand("Dell").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("269990")).discountedPrice(new BigDecimal("224990"))
                .imageUrl("https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=600&auto=format&fit=crop&q=80")
                .description("• 13th Gen Intel Core i9-13900H (14 Cores, up to 5.40 GHz)\n• 32 GB DDR5 4800MHz RAM | 1 TB PCIe NVMe SSD\n• NVIDIA GeForce RTX 4070 8GB GDDR6 Dedicated Graphics\n• 39.62 cm (15.6 inch) 3.5K OLED InfinityEdge Touch Display")
                .rating(4.8).reviewCount(4200).build(),

            Product.builder().name("HP Pavilion 15 Intel Core i5 13th Gen (16GB RAM / 512GB SSD / Win 11 / Backlit Keyboard)")
                .brand("HP").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("68990")).discountedPrice(new BigDecimal("54990"))
                .imageUrl("https://images.unsplash.com/photo-1544731612-de292439cc4b?w=600&auto=format&fit=crop&q=80")
                .description("• Intel Core i5-1335U 10-core Processor (up to 4.6 GHz)\n• 16 GB DDR4 RAM | 512 GB PCIe NVMe M.2 SSD\n• 39.6 cm (15.6 inch) FHD IPS Micro-edge Anti-glare Display\n• Audio by B&O, HP Wide Vision 720p HD Camera, Fast Charge (50% in 45 mins)")
                .rating(4.4).reviewCount(28400).build(),

            Product.builder().name("ASUS ROG Strix G16 Gaming Laptop (Intel Core i7 13th Gen / 16GB / 1TB SSD / 8GB RTX 4060 / 165Hz)")
                .brand("ASUS").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("144990")).discountedPrice(new BigDecimal("119990"))
                .imageUrl("https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=600&auto=format&fit=crop&q=80")
                .description("• Intel Core i7-13650HX 14-core Processor (up to 4.90 GHz)\n• 16 GB DDR5 4800MHz | 1 TB PCIe 4.0 NVMe SSD\n• NVIDIA GeForce RTX 4060 8GB GDDR6 (140W Max TGP)\n• 40.64 cm (16 inch) FHD+ 165Hz IPS Display with G-Sync & MUX Switch")
                .rating(4.7).reviewCount(15700).build(),

            Product.builder().name("Lenovo IdeaPad Slim 3 Intel Core i3 12th Gen (8GB RAM / 512GB SSD / Windows 11)")
                .brand("Lenovo").category("Electronics").subCategory("Laptops")
                .price(new BigDecimal("49990")).discountedPrice(new BigDecimal("34990"))
                .imageUrl("https://images.unsplash.com/photo-1588872657578-7efd1f1555ed?w=600&auto=format&fit=crop&q=80")
                .description("• Intel Core i3-1215U 6-core Processor (up to 4.4 GHz)\n• 8 GB DDR4 RAM | 512 GB SSD Storage\n• 39.62 cm (15.6 inch) FHD Anti-Glare 250 Nits Display\n• Dolby Audio, HD 720p Camera with Privacy Shutter, 1.63 kg Lightweight")
                .rating(4.3).reviewCount(38900).build(),

            // ─────────────── AUDIO & WEARABLES ───────────────
            Product.builder().name("Sony WH-1000XM5 Industry Leading Noise Cancelling Wireless Headphones")
                .brand("Sony").category("Electronics").subCategory("Headphones")
                .price(new BigDecimal("34990")).discountedPrice(new BigDecimal("26990"))
                .imageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600&auto=format&fit=crop&q=80")
                .description("• 8 Microphones with Auto NC Optimizer for Ultimate Noise Cancellation\n• 30mm Precision Driver delivers Hi-Res Audio wireless\n• Up to 30 Hours of Battery Life (3 min charge = 3 hours playback)\n• Speak-to-Chat, Multipoint Bluetooth pairing, Soft Fit Leather cushions")
                .rating(4.8).reviewCount(32600).build(),

            Product.builder().name("Apple AirPods Pro (2nd Generation) with MagSafe Case (USB-C)")
                .brand("Apple").category("Electronics").subCategory("Earphones")
                .price(new BigDecimal("24900")).discountedPrice(new BigDecimal("18999"))
                .imageUrl("https://images.unsplash.com/photo-1600294037681-c80b4cb5b434?w=600&auto=format&fit=crop&q=80")
                .description("• 2x more Active Noise Cancellation with Apple H2 Chip\n• Adaptive Audio and Personalized Spatial Audio with dynamic head tracking\n• Up to 6 hours listening time on single charge, up to 30 hours with Case\n• IP54 dust, sweat, and water resistant for AirPods and Case")
                .rating(4.8).reviewCount(41200).build(),

            Product.builder().name("boAt Airdopes 141 Bluetooth Truly Wireless in Ear Earbuds (42H Playtime)")
                .brand("boAt").category("Electronics").subCategory("Earphones")
                .price(new BigDecimal("4490")).discountedPrice(new BigDecimal("1199"))
                .imageUrl("https://images.unsplash.com/photo-1590658268037-6bf12165a8df?w=600&auto=format&fit=crop&q=80")
                .description("• Up to 42 Hours of Total Playtime with Fast Charging (5 mins charge = 75 mins)\n• 8mm Audio Drivers for boAt Signature Sound and Deep Bass\n• ENx Environmental Noise Cancellation Technology for clear voice calls\n• Beast Mode for 80ms Low Latency Mobile Gaming | IPX4 Water Resistance")
                .rating(4.2).reviewCount(189500).build(),

            Product.builder().name("JBL Flip 6 Portable Waterproof Bluetooth Speaker (Deep Bass, 12 Hrs Playtime)")
                .brand("JBL").category("Electronics").subCategory("Speakers")
                .price(new BigDecimal("13999")).discountedPrice(new BigDecimal("8999"))
                .imageUrl("https://images.unsplash.com/photo-1545454675-3531b543be5d?w=600&auto=format&fit=crop&q=80")
                .description("• 2-way speaker system with racetrack-shaped woofer and separate tweeter\n• IP67 Waterproof and Dustproof rating | 12 Hours of Playtime\n• JBL PartyBoost allows stereo pairing with multiple speakers\n• USB-C Charging protection | Rugged rubber housing")
                .rating(4.6).reviewCount(54300).build(),

            Product.builder().name("boAt Wave Sigma Smartwatch with 2.01 inch HD Display & Bluetooth Calling")
                .brand("boAt").category("Electronics").subCategory("Smartwatches")
                .price(new BigDecimal("7499")).discountedPrice(new BigDecimal("1299"))
                .imageUrl("https://images.unsplash.com/photo-1508685096489-7aacd43bd3b1?w=600&auto=format&fit=crop&q=80")
                .description("• 5.10 cm (2.01 inch) HD Display with 550 Nits Brightness\n• Advanced Bluetooth Calling with Dial Pad and Contact Sync\n• 700+ Active Modes for sports, fitness and workout tracking\n• Heart Rate, SpO2, Sleep and Stress Monitoring | IP67 Water Resistant")
                .rating(4.2).reviewCount(78400).build(),

            Product.builder().name("Apple Watch Series 9 GPS 45mm (Midnight Aluminium with Sport Band)")
                .brand("Apple").category("Electronics").subCategory("Smartwatches")
                .price(new BigDecimal("44900")).discountedPrice(new BigDecimal("37990"))
                .imageUrl("https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=600&auto=format&fit=crop&q=80")
                .description("• S9 SiP with 64-bit dual-core processor and Double Tap gesture\n• Always-On Retina LTPO OLED display, 2000 nits brightness\n• Blood Oxygen, ECG, Temperature sensing, Crash and Fall Detection\n• 50m Water resistant (swimproof) | Fast Magnetic USB-C Charging")
                .rating(4.8).reviewCount(27600).build(),

            // ─────────────── TELEVISIONS ───────────────
            Product.builder().name("Samsung 163 cm (65 inch) QLED Ultra HD (4K) Smart Tizen TV")
                .brand("Samsung").category("Electronics").subCategory("Televisions")
                .price(new BigDecimal("139900")).discountedPrice(new BigDecimal("84990"))
                .imageUrl("https://images.unsplash.com/photo-1593359677879-a4bb92f829d1?w=600&auto=format&fit=crop&q=80")
                .description("• 163 cm (65 inch) 4K Ultra HD (3840 x 2160) Display\n• 100% Color Volume with Quantum Dot technology\n• Quantum Processor Lite 4K with Dual LED backlighting\n• Object Tracking Sound Lite (OTS Lite) 3D surround audio\n• SolarCell Remote, Q-Symphony soundbar sync, Tizen OS")
                .rating(4.7).reviewCount(17400).build(),

            Product.builder().name("LG 139 cm (55 inch) 4K Ultra HD Smart WebOS OLED TV")
                .brand("LG").category("Electronics").subCategory("Televisions")
                .price(new BigDecimal("149990")).discountedPrice(new BigDecimal("99990"))
                .imageUrl("https://images.unsplash.com/photo-1461151304267-38535e780c79?w=600&auto=format&fit=crop&q=80")
                .description("• 139 cm (55 inch) Self-Lit OLED 4K (3840 x 2160) Display with infinite contrast\n• α7 AI Processor 4K Gen6 with AI Super Upscaling 4K\n• Dolby Vision IQ and Dolby Atmos for cinema-like experience\n• 120Hz refresh rate, 0.1ms response time, NVIDIA G-Sync and AMD FreeSync")
                .rating(4.8).reviewCount(11800).build(),

            // ─────────────── FASHION & SHOES ───────────────
            Product.builder().name("Nike Air Max 270 Men's Running Shoes (Triple Black)")
                .brand("Nike").category("Fashion").subCategory("Shoes")
                .price(new BigDecimal("13995")).discountedPrice(new BigDecimal("8495"))
                .imageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600&auto=format&fit=crop&q=80")
                .description("• Nike Max Air heel unit delivers unmatched, all-day cushioning\n• Knit fabric upper with no-sew overlays for lightweight breathability\n• Dual-density foam midsole provides plush, springy ride\n• Solid rubber outsole in the forefoot and clear rubber on heel for traction")
                .rating(4.6).reviewCount(21800).build(),

            Product.builder().name("Puma Men's Smash v2 Leather Sneakers (White & Black)")
                .brand("Puma").category("Fashion").subCategory("Shoes")
                .price(new BigDecimal("4999")).discountedPrice(new BigDecimal("2299"))
                .imageUrl("https://images.unsplash.com/photo-1525966222134-fcfa99b8ae77?w=600&auto=format&fit=crop&q=80")
                .description("• Genuine soft leather upper with classic tennis silhouette\n• SoftFoam+ comfort sockliner for instant step-in and long-lasting cushioning\n• Durable rubber outsole provides optimal grip and durability\n• PUMA Formstrip on lateral side and foil logo branding")
                .rating(4.3).reviewCount(48900).build(),

            Product.builder().name("Levi's Men's 511 Slim Fit Stretch Dark Blue Jeans")
                .brand("Levi's").category("Fashion").subCategory("Clothing")
                .price(new BigDecimal("3999")).discountedPrice(new BigDecimal("1999"))
                .imageUrl("https://images.unsplash.com/photo-1542272604-780c96856592?w=600&auto=format&fit=crop&q=80")
                .description("• 99% Cotton, 1% Elastane - Premium Stretch Denim\n• Modern slim-fit cut with room to move\n• Slim through the seat and thigh with a slim leg opening\n• Signature 5-pocket styling with arcuate stitch on back pockets\n• Levi's red tab and leather patch on back waistband")
                .rating(4.4).reviewCount(34500).build(),

            Product.builder().name("Allen Solly Men's Regular Fit Cotton Polo T-Shirt")
                .brand("Allen Solly").category("Fashion").subCategory("Clothing")
                .price(new BigDecimal("1299")).discountedPrice(new BigDecimal("699"))
                .imageUrl("https://images.unsplash.com/photo-1521572267360-ee0c2909d518?w=600&auto=format&fit=crop&q=80")
                .description("• 100% Combed Cotton fabric for maximum softness and breathability\n• Classic ribbed collar with two-button placket\n• Signature Allen Solly stag embroidery on chest\n• Half sleeves with ribbed cuffs | Machine washable")
                .rating(4.3).reviewCount(29100).build(),

            Product.builder().name("Biba Women's Printed Cotton Anarkali Kurta with Dupatta Set")
                .brand("Biba").category("Fashion").subCategory("Ethnic Wear")
                .price(new BigDecimal("4999")).discountedPrice(new BigDecimal("2199"))
                .imageUrl("https://images.unsplash.com/photo-1617627143750-d86bc21e42bb?w=600&auto=format&fit=crop&q=80")
                .description("• 3-Piece Festive Set: Anarkali Kurta, Churidar Pant & Chiffon Dupatta\n• 100% Pure Breathable Cotton Fabric with Golden Foil Print\n• Round neck with detailed embroidery work and three-quarter sleeves\n• Floor-length flared silhouette | Gentle hand wash recommended")
                .rating(4.5).reviewCount(17800).build(),

            // ─────────────── APPLIANCES ───────────────
            Product.builder().name("LG 8 Kg 5 Star Inverter Fully Automatic Front Load Washing Machine")
                .brand("LG").category("Appliances").subCategory("Washing Machines")
                .price(new BigDecimal("48990")).discountedPrice(new BigDecimal("34990"))
                .imageUrl("https://images.unsplash.com/photo-1626806787461-102c1bfaaea1?w=600&auto=format&fit=crop&q=80")
                .description("• 8 Kg Capacity: Suitable for 4-6 members | 5 Star Energy Rating\n• AI DD (Artificial Intelligence Direct Drive) detects fabric weight & softness\n• 6 Motion Direct Drive moves the wash drum in multiple directions\n• Steam Cycle eliminates 99.9% of allergens | LG ThinQ Wi-Fi Control")
                .rating(4.6).reviewCount(28900).build(),

            Product.builder().name("Samsung 253 L 3 Star Inverter Double Door Refrigerator")
                .brand("Samsung").category("Appliances").subCategory("Refrigerators")
                .price(new BigDecimal("31990")).discountedPrice(new BigDecimal("23990"))
                .imageUrl("https://images.unsplash.com/photo-1584992236310-6edddc08acff?w=600&auto=format&fit=crop&q=80")
                .description("• 253 Litres Capacity: Fresh food 184 L, Freezer 69 L\n• Digital Inverter Compressor with 20 Year Warranty\n• Stabilizer Free Operation (100V - 300V)\n• All-Round Cooling system cools evenly from corner to corner\n• Toughened Glass Shelves holding up to 175 kg safely")
                .rating(4.5).reviewCount(36400).build(),

            Product.builder().name("Dyson V12 Detect Slim Total Clean Cordless Vacuum Cleaner")
                .brand("Dyson").category("Appliances").subCategory("Vacuum Cleaners")
                .price(new BigDecimal("55900")).discountedPrice(new BigDecimal("43900"))
                .imageUrl("https://images.unsplash.com/photo-1558317374-067fb5f30001?w=600&auto=format&fit=crop&q=80")
                .description("• Laser reveals invisible dust on hard floors\n• Piezo sensor continuously sizes and counts dust particles\n• Hyperdymium motor spins up to 125,000 rpm for deep cleaning\n• LCD screen shows real-time scientific proof of clean | 60 min battery")
                .rating(4.7).reviewCount(8700).build(),

            Product.builder().name("Voltas 1.5 Ton 5 Star Inverter Split AC (Copper, 4-in-1 Adjustable)")
                .brand("Voltas").category("Appliances").subCategory("Air Conditioners")
                .price(new BigDecimal("75990")).discountedPrice(new BigDecimal("37990"))
                .imageUrl("https://images.unsplash.com/photo-1614633833026-06201b138d61?w=600&auto=format&fit=crop&q=80")
                .description("• 1.5 Ton Capacity: Suitable for medium sized rooms (up to 150 sq ft)\n• 5 Star BEE Energy Rating with eco-friendly R32 refrigerant\n• 4-in-1 Adjustable Mode runs at 4 different cooling capacities\n• 100% Copper Condenser with Anti-Corrosive Blue Fin Coating\n• Anti-dust & Antimicrobial Filter | Ambient cooling even at 52°C")
                .rating(4.4).reviewCount(42100).build(),

            // ─────────────── BESTSELLER BOOKS ───────────────
            Product.builder().name("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones")
                .brand("Penguin").category("Books").subCategory("Self Help")
                .price(new BigDecimal("799")).discountedPrice(new BigDecimal("399"))
                .imageUrl("https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=600&auto=format&fit=crop&q=80")
                .description("• Author: James Clear | Over 15 Million Copies Sold Worldwide\n• #1 New York Times Bestseller | Paperback Edition (320 Pages)\n• A supremely practical framework to change your habits on a daily basis\n• Learn how small 1% improvements lead to massive life transformations")
                .rating(4.9).reviewCount(142000).build(),

            Product.builder().name("The Psychology of Money: Timeless Lessons on Wealth, Greed, and Happiness")
                .brand("Jaico").category("Books").subCategory("Finance")
                .price(new BigDecimal("499")).discountedPrice(new BigDecimal("275"))
                .imageUrl("https://images.unsplash.com/photo-1592496431122-2349e0fbc666?w=600&auto=format&fit=crop&q=80")
                .description("• Author: Morgan Housel | International Bestseller\n• 19 short stories exploring the strange ways people think about money\n• Teaches you how to have a better relationship with money and build long-term wealth\n• Paperback Edition (252 Pages) | High quality print")
                .rating(4.8).reviewCount(89400).build(),

            Product.builder().name("Rich Dad Poor Dad by Robert T. Kiyosaki (25th Anniversary Edition)")
                .brand("Plata").category("Books").subCategory("Finance")
                .price(new BigDecimal("499")).discountedPrice(new BigDecimal("249"))
                .imageUrl("https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=600&auto=format&fit=crop&q=80")
                .description("• What the Rich Teach Their Kids About Money That the Poor and Middle Class Do Not!\n• The #1 Personal Finance book of all time with over 40 million copies sold\n• Explodes the myth that you need to earn a high income to become rich\n• 336 Pages | Paperback")
                .rating(4.7).reviewCount(118500).build(),

            Product.builder().name("Harry Potter Box Set: The Complete Collection (Children's Paperback)")
                .brand("Bloomsbury").category("Books").subCategory("Fiction")
                .price(new BigDecimal("4999")).discountedPrice(new BigDecimal("2999"))
                .imageUrl("https://images.unsplash.com/photo-1512820790803-83ca734da794?w=600&auto=format&fit=crop&q=80")
                .description("• Complete 7-Book Boxset by J.K. Rowling in a handsome presentation slipcase\n• Contains all 7 novels from Philosopher's Stone to Deathly Hallows\n• Perfect gift edition for fantasy lovers, collectors, and young readers\n• Over 4,000 pages of magical reading")
                .rating(4.9).reviewCount(64200).build(),

            // ─────────────── GAMING & ACCESSORIES ───────────────
            Product.builder().name("Sony PlayStation 5 Console (Disc Edition) with DualSense Controller")
                .brand("Sony").category("Electronics").subCategory("Gaming")
                .price(new BigDecimal("54990")).discountedPrice(new BigDecimal("47990"))
                .imageUrl("https://images.unsplash.com/photo-1606813907291-d86efa9b94db?w=600&auto=format&fit=crop&q=80")
                .description("• Ultra-High Speed Custom 825 GB SSD for near-instant load times\n• Ray Tracing delivers true-to-life shadows and reflections\n• 4K-TV Gaming at up to 120fps with 120Hz output\n• Tempest 3D AudioTech puts you at the centre of the action\n• DualSense Wireless Controller with Haptic Feedback and Adaptive Triggers")
                .rating(4.9).reviewCount(52100).build(),

            Product.builder().name("Logitech G502 HERO High Performance Gaming Mouse (16,000 DPI)")
                .brand("Logitech").category("Electronics").subCategory("Gaming")
                .price(new BigDecimal("4995")).discountedPrice(new BigDecimal("3495"))
                .imageUrl("https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?w=600&auto=format&fit=crop&q=80")
                .description("• HERO 25K Sensor with sub-micron tracking and zero smoothing or acceleration\n• 11 Customizable Buttons and onboard memory to save your game profiles\n• Adjustable weight system with 5 removable 3.6g weights inside\n• LIGHTSYNC RGB Technology with 16.8 million colors\n• Mechanical switch button tensioning")
                .rating(4.7).reviewCount(38200).build()
        ));

        System.out.println("✅ " + productRepository.count() + " rich products loaded into database with high-res photos!");
    }
}
